package Assignment3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageObjectModel
{
        String url = "https://juice-shop.herokuapp.com/#/register";
        By dismissbtn = By.xpath("//span[text() = 'Dismiss']");
        By emailbtn = By.id("emailControl");
        By pswdbtn = By.id("passwordControl");
        By repeatpwdbtn = By.id("repeatPasswordControl");
        By securityqtnclick = By.id("mat-select-value-1");
        By selectingqtn = By.xpath("(//span[@class = 'mat-option-text'])[3]");
        By answerbtn = By.id("securityAnswerControl");
        By rgstrbtn = By.id("registerButton");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport1.html");
    @Test
    public void registration() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       driver.get(url);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
       driver.manage().window().maximize();
       ExtentTest test =extent.createTest("register").assignAuthor("madhuri").assignCategory("sample testing").assignDevice("chrome");
       driver.findElement(dismissbtn).click();
       driver.findElement(emailbtn).sendKeys("dummy6@gmail.com");
       driver.findElement(pswdbtn).sendKeys("juicershop1234!A");
       driver.findElement(repeatpwdbtn).sendKeys("juicershop1234!A");
       driver.findElement(securityqtnclick).click();
       driver.findElement(selectingqtn).click();
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(answerbtn).sendKeys("june4");
        Thread.sleep(3000);
       driver.findElement(rgstrbtn).click();
       test.log(Status.FAIL,"Registration");
       //test.pass("registration verified");
       extent.attachReporter(spark);
       extent.flush();

    }
}
