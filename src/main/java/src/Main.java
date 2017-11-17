package src;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String args[]) throws Exception {
        System.out.println("Eboook Reader Start!");

        //check if the internet is ok; cause the service is based on online api
        boolean internetReachablity = InternetTester.isReachable2();
        if(internetReachablity){
            System.out.println("网络一切正常");
        }
        else{
            System.out.println("网络连接有问题。程序终止。");
            System.exit(0);
        }


        // get the book path and find the related type
        Scanner sc=new Scanner(System.in);
        String filepath=null;
        System.out.print("请输入电子书所在位置（目前支持epub、txt、pdf格式）:");
        filepath=sc.nextLine();
        int index = 0;
        if(filepath.contains("pdf")){
            index = 1; //pdf
            System.out.println("reading pdf");

        }
        if(filepath.contains("epub")){
            System.out.println("reading epub");
            index = 2;
            try {
                epubTTSProcessor.epubTTSProcessing(filepath,"文明之光");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(filepath.contains("txt")){
            System.out.print("reading txt");
            index = 3;
        }


        // do processing according to the file's format
        switch (index){
            // pdf processing
            case 1:
                System.out.println("reading start");

                break;

            // epub processing
            case 2:
                System.out.println("reading start");

                break;

            // txt processing
            case 3:
                System.out.println("reading start");
                break;
            default:
                break;
        }

        System.out.println("Ebook Reader End!");

    }
}