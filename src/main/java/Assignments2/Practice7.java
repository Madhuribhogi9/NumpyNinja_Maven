package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class Practice7
{
    private static ChromeDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dsportalapp.herokuapp.com/tryEditor");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//pre[@class =' CodeMirror-line ']")).click();
        //WebElement ele = driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']"));
       // Wait<WebDriver> waits = new FluentWait<WebDriver>(driver);
       //WebElement ele = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']"))));
      // driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']")).sendKeys("madhu");
        //driver.findElement(By.xpath("//div[@class ='CodeMirror-scroll']")).sendKeys("madhu");
        //WebDriverWait wait = new WebDriverWait(driver, 300);
        //WebElement element = wait.until(
                //ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        //driver.findElement(By.id("Passwd")).sendKeys("xyz");
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']")) );
        //driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']")).sendKeys("madhu");
        //WebElement ele = driver.findElement(By.xpath("//div[@class = 'CodeMirror-scroll']"));
        //driver.switchTo().frame(ele);
        //driver.findElement(By.xpath("//pre[@class = ' CodeMirror-line ']")).sendKeys("madhu");
        driver.findElement(By.xpath("//form/div/div/div/textarea")).sendKeys("madhu");
        //driver.findElement(By.xpath())


    }
}
