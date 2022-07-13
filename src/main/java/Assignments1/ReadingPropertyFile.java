package Assignments1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertyFile
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\NumpyNinja_Maven\\src\\main\\java\\data1.properties");
        Properties p = new Properties();
        p.load(fis);
        System.out.println(p);
    }
}
