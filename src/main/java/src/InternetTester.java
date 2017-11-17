package src;




import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;

public class InternetTester {

    private static String remoteInetAddr = "www.baidu.com";//需要连接的IP地址
    /**
     * 传入需要连接的IP，返回是否连接成功
     * @param remoteInetAddr
     * @return
     */
    public static boolean isReachable(String remoteInetAddr) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }


    public static boolean isReachable2(){
        System.out.println("检测网络中");
        URL url = null;
        Boolean bon = false;
        Boolean exception = false;
        try {
            url = new URL("http://www.baidu.com/");
            InputStream in = url.openStream();//打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream
            in.close();//关闭此输入流并释放与该流关联的所有系统资源。网络连接成功
        } catch (IOException e) {
            exception = true;
        }

        bon = isReachable(remoteInetAddr);
        if(exception == true){
            bon = false;
        }
        else{
            bon = true;
        }
        return bon;
    }

    public static void main(String[] args) {

        System.out.println("网络检测完毕");

    }


}
