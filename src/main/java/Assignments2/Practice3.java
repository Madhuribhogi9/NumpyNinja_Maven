package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void BedsAvailability() throws InterruptedException
    {
        for (int j = 1; j <4 ; j++)
        {
            Select s = new Select(driver.findElement(By.name("ddlZone")));
            //Thread.sleep(3000);
            s.selectByIndex(j);
            s = new Select(driver.findElement(By.name("ddlZone")));
            //Thread.sleep(3000);
            WebElement zone = s.getFirstSelectedOption();
            //Thread.sleep(3000);
            System.out.println("Zone = " + zone.getText());


            for (int i = 1; i < 10; i++)
            {
                Wait <WebDriver> waits = new FluentWait<WebDriver>(driver);

                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,50)");
                String HospitalName = driver.findElement(By.xpath("//div[@class = 'card custom-card'][" + i + "]//div/a")).getText();
                System.out.println("Hospital name =" + HospitalName);

               // Thread.sleep(3000);
                WebElement AvailableBeds = driver.findElement(By.xpath("//div[@class = 'card custom-card'][" + i + "]//div[@class = 'col-md-6'][2]//span[contains(text(),'Beds')]"));
                //String AvailableBedst = waits.until(ExpectedConditions.visibilityOf(AvailableBeds)).getText();
                System.out.println("Total Available beds =" + AvailableBeds.getText());

                WebElement clicking = driver.findElement(By.xpath("(//div[@class = 'card custom-card']//a[@class = ' hospital-info'])[" + i + "]"));

                Actions a = new Actions(driver);
                a.moveToElement(clicking).build().perform();
                clicking.click();
                Thread.sleep(2000);
                 WebElement numbers =  driver.findElement(By.xpath("//span[@id='lblhosCno']"));
                //WebElement numbers = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='lblhosCno']"))));
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

        }





    }
}
