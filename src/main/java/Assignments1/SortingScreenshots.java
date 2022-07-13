package Assignments1;

import javafx.util.Pair;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SortingScreenshots
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
            sortingscreenshots(docx,run,out);
        }
    public static Pair<Long, File> capturescreenshotByPair() throws IOException
    {
        Map<Long, File> map1 = new HashMap<Long, File>();
        String screenshot_name = System.currentTimeMillis() + ".png";
        Long time = System.currentTimeMillis();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String fileName = String.format("C:\\Users\\admin\\Desktop\\PastingScreenshots.png" + screenshot_name);
        File dest = new File(fileName);
        FileUtils.copyFile(src, dest);
        Pair<Long, File> pair = new Pair<Long, File>(time, dest);
        return pair;
    }
        public static void sortingscreenshots(XWPFDocument docx, XWPFRun run,FileOutputStream out) throws IOException, InvalidFormatException, InterruptedException
        {
            Map<Long, File> map2 = new LinkedHashMap<Long, File>();
            for (int i = 0; i <5 ; i++)
            {
                Pair<Long, File> pair = capturescreenshotByPair();
                 map2.put(pair.getKey(), pair.getValue());
            }
            List<Long> list1 = new ArrayList<Long>(map2.keySet());
            Collections.sort(list1);
            for (Long aLong : list1)
            {
                String screenshot_name = aLong + ".png";
                File file1 = map2.get(aLong);
                InputStream pic = new FileInputStream(file1);
                run.addBreak();
                String fileName = String.format("C:\\Users\\admin\\Desktop\\PastingScreenshots.png" + screenshot_name);
                XWPFPicture xwpfPicture = run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, fileName, Units.toEMU(350), Units.toEMU(350));
                pic.close();
                file1.delete();
                TimeUnit.SECONDS.sleep(1);
            }
            docx.write(out);
            out.flush();
            out.close();
            docx.close();
        }

        }
