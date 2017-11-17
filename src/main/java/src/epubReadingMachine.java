/*
Reading contents from epub, using Epublib java jar lib.
The docs can be found from
http://www.siegmann.nl/static/epublib/apidocs/
 */


package src;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;

import java.io.*;
import java.util.List;




public class epubReadingMachine {

    private static Book mybook;

    // must use the init function first
    public static void init(String epubFilePath){
        // read epub file
        EpubReader epubReader = new EpubReader();
        Book book = null;
        try {
            book = epubReader.readEpub(new FileInputStream(epubFilePath));
            mybook = book;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getTextFromEpubByPage(String epubFilePath, int readingPage) {

        Book book = mybook;
        // get the resource of the book
        List<Resource> contents = book.getContents();
        int size = contents.size();
        if (readingPage >= 1 && readingPage < size) {

        } else {
            System.out.println("out of index");
            System.exit(0);
        }

        Resource content = contents.get(readingPage);

        // print the resource of the book
        InputStream is = null;
        try {
            is = content.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String line;
        String result = "";
        try {
            while ((line = r.readLine()) != null) {
                result = result + HTMLSpirit.delHTMLTag(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int getBookContentSize(){
        return mybook.getContents().size();
    }

    /* Other examples of using pdfbox
    // print the first title
        List<String> titles = book.getMetadata().getTitles();
        String lan = book.getMetadata().getLanguage();
        System.out.println("book title" + (titles.isEmpty() ? "book has no title" : titles.get(0)));

        // print the books's language
        System.out.println("language: " + lan);


        // get the resource of the book
        List<Resource> contents = book.getContents();

        // print the book's resource's size
        System.out.println("Resources' size: "+contents.size());

        Resource content = contents.get(15);
     */


    /* epubReadingMachine running samples
    public static void main(String args[]){
        String result = epubReadingMachine.getTextFromPDFByPage("/Users/Haoran/Downloads/程序员的思维修炼.epub",10);
        System.out.println(result);
    }
    */
}
