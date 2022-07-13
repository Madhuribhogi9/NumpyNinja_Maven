package Assignments1;

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

public class screenshotinselenium
{
     private static WebDriver driver;

    public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        XWPFDocument docx = new XWPFDocument();
        XWPFRun run = docx.createParagraph().createRun();
        FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\Doc1.docx");
        for (int i = 0; i <5 ; i++)
        {
            capturescreenshot(docx,run,out);
            TimeUnit.SECONDS.sleep(1);
        }
        docx.write(out);
        out.flush();
        out.close();
        docx.close();
    }
    public static void capturescreenshot(XWPFDocument docx, XWPFRun run,FileOutputStream out) throws IOException, InvalidFormatException
    {
        String screenshot_name = System.currentTimeMillis() + ".png";
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String fileName = String.format("C:\\Users\\admin\\Desktop\\PastingScreenshots.png"+screenshot_name);
        File dest = new File(fileName);
        FileUtils.copyFile(src, dest);
        InputStream pic = new FileInputStream(dest);
        run.addBreak();
        XWPFPicture xwpfPicture = run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, fileName, Units.toEMU(350), Units.toEMU(350));
        pic.close();
        dest.delete();
    }



    }

