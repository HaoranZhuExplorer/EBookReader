package src;


/*
A processor that uses epubReadingMachine and longTTS and WavAppender to generate a total wav music format file

*/


public class epubTTSProcessor {

    /*
    general function: input an epub file and generate a wav music.
    input para:
        filepath: the path of the epub file
        filename: the name of the generated wav file
    */
    public static void epubTTSProcessing(String filepath, String filename) throws Exception {

        longTTS lun = new longTTS();
        epubReadingMachine.init(filepath);
        int size = epubReadingMachine.getBookContentSize();
        System.out.println("content size: "+size);

        for(int i=1;i<=size;i++) {
            System.out.println("processing the first content");
            lun.setText(epubReadingMachine.getTextFromEpubByPage(filepath, i));
            lun.setFileName("文明之光"+String.valueOf(i));
            lun.start();
            lun.sayIt();
            lun.shutDown();
            System.out.println("content "+String.valueOf(i)+" processed finished");
        }
    }

}
