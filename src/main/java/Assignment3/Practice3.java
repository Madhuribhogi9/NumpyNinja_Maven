package Assignment3;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Practice3
{
    WebDriver driver;
    @BeforeMethod
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }
    @Test
    public void BedsAvailability() throws InterruptedException, IOException, InvalidFormatException
    {
        for (int j = 1; j <5 ; j++)
        {
            Select s = new Select(driver.findElement(By.name("ddlZone")));
            s.selectByIndex(j);
            s = new Select(driver.findElement(By.name("ddlZone")));
            WebElement zone = s.getFirstSelectedOption();
            System.out.println("Zone = " + zone.getText());
            XWPFDocument docx = new XWPFDocument();
            XWPFRun run = docx.createParagraph().createRun();
            FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\covidscreenshots"+zone.getText()+".docx");
            Map<Long,File> map = new HashMap<Long, File>();
            for (int i = 1; i < 10; i++)
            {
                Wait<WebDriver> waits = new FluentWait<WebDriver>(driver);

                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,50)");
                String HospitalName = driver.findElement(By.xpath("//div[@class = 'card custom-card'][" + i + "]//div/a")).getText();
                System.out.println("Hospital name =" + HospitalName);
                Thread.sleep(3000);
                takingscreenshot(docx,run,out);
                Thread.sleep(3000);
                WebElement AvailableBeds = driver.findElement(By.xpath("//div[@class = 'card custom-card'][" + i + "]//div[@class = 'col-md-6'][2]//span[contains(text(),'Beds')]"));
                System.out.println("Total Available beds =" + AvailableBeds.getText());
                WebElement clicking = driver.findElement(By.xpath("(//div[@class = 'card custom-card']//a[@class = ' hospital-info'])[" + i + "]"));
                Actions a = new Actions(driver);
                a.moveToElement(clicking).build().perform();
                clicking.click();
                Thread.sleep(2000);
                WebElement numbers =  driver.findElement(By.xpath("//span[@id='lblhosCno']"));
                System.out.println("number = " + numbers.getText());
                Thread.sleep(3000);
                String address = driver.findElement(By.xpath("//div[@class = 'modal-content']//li//label")).getText();
                System.out.println("address = " + address);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text() = '×']")).click();
                Thread.sleep(3000);
                String o2Beds = driver.findElement(By.xpath("(//div[@class = 'card custom-card']//ul//li[2]//div[@class = 'count-text'])[" + i + "]")).getText();
                System.out.println("o2 beds availability = " + o2Beds);
                Thread.sleep(3000);
                WebElement ventilatorWebElement = driver.findElement(By.xpath("(//div[@class = 'card custom-card']//ul//li[4]//div[@class = 'count-text'])[" + i + "]"));
                String ventilators = ventilatorWebElement.getText();
                System.out.println("ventilators = " + ventilators);
            }
            docx.write(out);
            out.flush();
            out.close();
            docx.close();
        }

    }
    private void takingscreenshot(XWPFDocument docx, XWPFRun run,FileOutputStream out) throws IOException, InvalidFormatException
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
