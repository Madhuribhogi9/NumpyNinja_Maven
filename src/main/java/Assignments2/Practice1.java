package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice1
{

    WebDriver driver;
    @BeforeMethod
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice/");
    }
    @Test
    public void GivingDetails()
    {
        driver.findElement(By.id("firstname")).sendKeys("madhu");
        driver.findElement(By.className("lastname")).sendKeys("bhogi");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.name("language_java")).click();
        driver.findElement(By.name("age")).click();
        driver.findElement(By.xpath("//option[text() = 'Under 30']")).click();
        driver.findElement(By.id("submit_htmlform")).click();
    }
    @AfterMethod
    public void CloseApp()
    {
        driver.close();
    }
}
