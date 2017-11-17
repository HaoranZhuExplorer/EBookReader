package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.util.PDFTextStripper;


public class PDFReader {
    /**
     * simply reader all the text from a pdf file.
     * You have to deal with the format of the output text by yourself.
     * 2008-2-25
     * @param pdfFilePath file path
     * @return all text in the pdf file
     */
    public static String getTextFromPDF(String pdfFilePath)
    {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(pdfFilePath);

            PDFParser parser = new PDFParser(is);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String getTextFromPDFByPage(String pdfFilePath, int startPage, int endPage)
    {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(pdfFilePath);

            PDFParser parser = new PDFParser(is);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(startPage);
            stripper.setEndPage(endPage);
            result = stripper.getText(document);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



    //PDF Reader Running demo
    /*public  static void main(String[] args)
    {
        System.out.println("PDF Reading Demo start");
        String str=PDFReader.getTextFromPDFByPage("/Users/Haoran/Downloads/SLAM.pdf",10,10);
        System.out.println(str);
        System.out.print("PDF Reading Demo end");

    }*/
}