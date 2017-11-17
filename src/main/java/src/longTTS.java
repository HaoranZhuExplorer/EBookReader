package src;


import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.NlsFuture;
import com.alibaba.idst.nls.event.NlsEvent;
import com.alibaba.idst.nls.event.NlsListener;
import com.alibaba.idst.nls.protocol.NlsRequest;
import com.alibaba.idst.nls.protocol.NlsRequestASR;
import com.alibaba.idst.nls.protocol.NlsRequestProto;
import com.alibaba.idst.nls.protocol.NlsResponse;
import com.alibaba.idst.nls.utils.PcmToWav;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.UUID;
/**
 * Created by songsong.sss on 16/12/12.
 */
public class longTTS implements NlsListener {
    static Logger logger = LoggerFactory.getLogger(longTTS.class);
    private NlsClient client = new NlsClient();
    public static String appKey = "nls-service";
    private static String auth_Id = "LTAIxgGdqx3yTzR5";
    private static String auth_Secret = "e8G6CJr9ieItkrDaNwW8wberhgoFef";
    public String tts_text ;
    private String fileName = "";
    public longTTS() {
    }
    public void shutDown() {
        logger.info("close NLS client");
        client.close();
        logger.info("demo done");
    }


    public void setText(String text){
        tts_text = text;
    }

    public void setFileName(String filename){
        this.fileName = filename;
    }

    public void start() {
        logger.info("init Nls client...");
        client.init();
    }
    public void sayIt() throws Exception {
        int ttsTextLength = tts_text.length();
        String[] longTexts;
        int i = 0;
        boolean isHead = false; //标识是否是第一个头文件
        String tts_part_text;
        File file = new File(fileName+".pcm");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileOutputStream outputStream = new FileOutputStream(file, true);
        longTexts = processLongText(tts_text);

        int initial_length = ttsTextLength;

        //处理文本,文本长度以50为限,截取为多个文件.
        while (ttsTextLength > 0) {
            double processing_rate = (initial_length-ttsTextLength)/(double)(initial_length)*100;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("processing rate: "+df.format(processing_rate)+"%");
            tts_part_text = "";
            if (ttsTextLength > 50) {
                if (i == 0) {
                    isHead = true;
                } else {
                    isHead = false;
                }
                for (; i < longTexts.length; i++) {
                    tts_part_text = tts_part_text + longTexts[i];
                    if (i < longTexts.length - 1 && tts_part_text.length() + longTexts[i + 1].length() >= 50) {
                        i = i + 1;
                        break;
                    }
                }
            } else {
                if (i == 0) {
                    isHead = true;
                }
                for (; i < longTexts.length; i++) {
                    tts_part_text = tts_part_text + longTexts[i];
                }
            }
            NlsRequest req = new NlsRequest();
            req.setApp_key("nls-service");
            req.setTts_req(tts_part_text, "16000");
            req.setTtsEncodeType("wav");
            req.setTtsVoice("xiaoyun");//男声:xiaogang
            req.setTtsVolume(50);
            req.setTtsBackgroundMusic(1, 0);
            req.authorize(auth_Id, auth_Secret);
            NlsFuture future = client.createNlsFuture(req, this);
            int total_len = 0;
            byte[] data;
            while ((data = future.read()) != null) {
                if (data.length == 8044 ) {
                    // 去掉wav头,同时将多条wav转成一条pcm
                    logger.debug("data length:{} , and head is:{}", (data.length - 44), isHead ? "true" : "false");
                    outputStream.write(data, 44, data.length - 44);
                } else {
                    outputStream.write(data, 0, data.length);
                }
                total_len += data.length;
            }
            logger.info("tts audio file size is :" + total_len);
            future.await(10000);
            ttsTextLength = ttsTextLength - tts_part_text.length();
        }
        outputStream.close();
        //将pcm转为wav,可以直接播放. 格式为:16kHz采样率,16bit,单声道
        PcmToWav.copyWaveFile(fileName+".pcm",fileName+".wav");
        logger.debug("close the wav file!");
    }
    @Override
    public void onMessageReceived(NlsEvent e) {
        NlsResponse response = e.getResponse();
        String result = "";
        if (response.getDs_ret() != null) {
            result = "get ds result: " + response.getDs_ret();
        }
        if (response.getAsr_ret() != null) {
            result += "\nget asr result: " + response.getAsr_ret();
        }
        if (response.getTts_ret() != null) {
            result += "\nget tts result: " + response.getTts_ret();
        }
        if (response.getGds_ret() != null) {
            result += "\nget gds result: " + response.getGds_ret();
        }
        if (!result.isEmpty()) {
            logger.info(result);
        } else if (response.jsonResults != null) {
            logger.info(response.jsonResults.toString());
        } else {
            logger.info("get an acknowledge package from server.");
        }
    }
    @Override
    public void onOperationFailed(NlsEvent e) {
        logger.error("Error message is: {}, Error code is: {}", e.getErrorMessage(), Integer.valueOf(e.getResponse().getStatus_code()));
    }
    //切分长文本
    public static String[] processLongText(String text) {
        text = text.replaceAll("、", "、|");
        text = text.replaceAll("，", "，|");
        text = text.replaceAll("。", "。|");
        text = text.replaceAll("；", "；|");
        text = text.replaceAll("？", "？|");
        text = text.replaceAll("！", "！|");
        text = text.replaceAll(",", ",|");
        text = text.replaceAll(";", ";|");
        text = text.replaceAll("\\?", "?|");
        text = text.replaceAll("!", "!|");
        String[] texts = text.split("\\|");
        return texts;
    }
    @Override
    public void onChannelClosed(NlsEvent e) {
        logger.info("on websocket closed.");
    }
    /**
     * @param args
     */


    // example to use longTTS
    /*
    public static void main(String[] args) throws Exception {
        longTTS lun = new longTTS();

        //lun.appKey = longTTS.appKey;
        //lun.auth_Id = longTTS.auth_Id;
        //lun.auth_Secret = longTTS.auth_Secret;

        lun.setText(epubReadingMachine.getTextFromPDFByPage("/Users/Haoran/Downloads/程序员的思维修炼.epub",10));
        lun.setFileName("程序员的思维修炼");
        lun.start();
        lun.sayIt();
        lun.shutDown();
    }
    */


}