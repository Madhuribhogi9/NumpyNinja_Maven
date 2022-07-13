package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice4
{
    WebDriver driver;
    @BeforeMethod
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://westbengal.covidsafe.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
    }
    @Test
    public void CovidSafeWestBengalApp() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 1; i <8 ; i++)
        {
            String HospitalName = driver.findElement(By.xpath("(//tr[@style= 'cursor: pointer;']//button//strong)[" +i+ "]")).getText();
            System.out.println("hospital name = " + HospitalName);
            Thread.sleep(3000);

            driver.findElement(By.xpath("(//tr[@style= 'cursor: pointer;']//button//strong)[" +i+ "]")).click();
            js.executeScript("window.scrollBy(0,220)");

            String number = driver.findElement(By.xpath("(//table/tbody//span[contains(text(),'Phone')])[" +i+ "]")).getText();
            System.out.println("number=" + number);

            String withoutoxygen = driver.findElement(By.xpath("(//td[@class = 'text-center']//span[@style = 'font-size: 20px;'])[" +i+ "]")).getText();
            System.out.println("Without Oxygen =" + withoutoxygen);
            Thread.sleep(3000);

            String withoxygen = driver.findElement(By.xpath("(//td[@class = 'text-center']//span[@style = 'font-size: 20px;'])[" +i+1+ "]")).getText();
            System.out.println("With Oxygen =" + withoxygen);
            Thread.sleep(3000);

            String Icuwithoutventi = driver.findElement(By.xpath("(//td[@class = 'text-center']//span[@style = 'font-size: 20px;'])[" +i+2+ "]")).getText();
            System.out.println("Icu Without Ventilator =" + Icuwithoutventi);
            Thread.sleep(3000);

            String Icuwithventi = driver.findElement(By.xpath("(//td[@class = 'text-center']//span[@style = 'font-size: 20px;'])[" +i+3+ "]")).getText();
            System.out.println("Icu With Ventilator =" + Icuwithventi);
            Thread.sleep(3000);

        }



    }




}
