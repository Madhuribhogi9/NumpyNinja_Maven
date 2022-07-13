package Assignment3;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class gettingscreenshotsinfolder
{
    public static void screenshot() throws IOException, InvalidFormatException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        File f1 = new File("C:\\Users\\admin\\Desktop\\practice1");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\admin\\Desktop\\practice1\\firstone.png");
        FileUtils.copyFile(src, dest);
        System.out.println(System.currentTimeMillis());
    }

    public static void takingscreenshotsfromfoldertofile() throws IOException, InvalidFormatException
    {
        XWPFDocument docx = new XWPFDocument();
        XWPFRun run = docx.createParagraph().createRun();
        FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\Doc2.docx");
        String fileName = "onescreenshot";
        FileInputStream fin = new FileInputStream("C:\\Users\\admin\\Desktop\\practice1\\firstone.png");
        run.addBreak();
        XWPFPicture xwpfPicture = run.addPicture(fin, XWPFDocument.PICTURE_TYPE_PNG, fileName, Units.toEMU(350), Units.toEMU(350));
        fin.close();
        docx.write(out);
        out.flush();
        out.close();
        docx.close();
    }


    public static void main(String[] args) throws IOException, InvalidFormatException
    {
           screenshot();
           takingscreenshotsfromfoldertofile();
    }
}
