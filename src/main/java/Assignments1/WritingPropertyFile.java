package Assignments1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

public class WritingPropertyFile
{
    public static void main(String[] args) throws IOException, InvalidFormatException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");

        Properties p = new Properties();
        HashMap<String,String> hs = new LinkedHashMap<String, String>();

        hs.put("1","madhuri");
        hs.put("2","swathi");
        hs.put("3","anjali");
        p.putAll(hs);

        FileOutputStream fout = new FileOutputStream("C:\\NumpyNinja_Maven\\src\\main\\java\\data4.properties");
        p.store(fout,"sample property file");


    }
}
