package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice2
{
    WebDriver driver;
    @BeforeMethod
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
    }
    @Test
    public void GivingDetails()
    {
        driver.findElement(By.name("firstname")).sendKeys("madhuri");
        driver.findElement(By.name("lastname")).sendKeys("bhogi");
        driver.findElement(By.xpath("//input[@value = 'Female']")).click();
        driver.findElement(By.xpath("//input[@value = '1']")).click();
        driver.findElement(By.xpath("(//input[contains(@style, 'width:95%;padding:4px 0px 4px 5px;margin:4px 0px')])[3]")).sendKeys("5/15/2022");
        driver.findElement(By.xpath("//span[@style = 'margin-right:8px']//input[@value = 'Automation Tester']")).click();
        driver.findElement(By.xpath("//span[@style = 'margin-right:8px']//input[@value = 'Selenium IDE']")).click();
    }
    @AfterMethod
    public void CloseApp()
    {
        //driver.close();
    }

}
