package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice5
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");

        for(int i=1;i<=10;i++)
        {

            WebElement hospNameEle = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//a"))));

            String hospName = hospNameEle.getText();
            System.out.println(hospName);

            String totalbeds = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//span[contains(text(),'Total Beds')]")).getText();
            System.out.println(totalbeds);

            String vacantBeds = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//span[contains(text(),'Vacant')]")).getText();
            System.out.println(vacantBeds);

            driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//div[@class='container']")).click();

            String oxygen = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//li[2]//div[2]")).getText();

            System.out.println("Oxygen beds : " + oxygen);

            String ventilator = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//li[4]//div[2]")).getText();

            System.out.println("Ventilator beds : " + ventilator);

            WebElement hosplink = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//a"));
            Actions action = new Actions(driver);
            action.moveToElement(hosplink).build().perform();
            hosplink.click();

            WebElement phoneNo = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='lblhosCno']"))));

            //String phone = driver.findElement(By.xpath("//span[@id='lblhosCno']")).getText();

            System.out.println("Phone number : " + phoneNo.getText());

            String address = driver.findElement(By.xpath("//label[@id='lblhosaddress']")).getText();
            System.out.println("Address : " + address);

            driver.findElement(By.xpath("//div[@class='modal-content']//button/span")).click();
        }



        }
}
