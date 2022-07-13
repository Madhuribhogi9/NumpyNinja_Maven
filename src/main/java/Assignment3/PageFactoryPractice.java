package Assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageFactoryPractice implements ITestListener
{

    String url = "https://juice-shop.herokuapp.com/#/register";
    @FindBy(xpath = "//span[text() = 'Dismiss']") WebElement dismissbtn;
    @FindBy(id ="emailControl") WebElement emailbtn;
    @FindBy(id = "passwordControl") WebElement pswdbtn;
    @FindBy (id = "repeatPasswordControl") WebElement repeatpwdbtn;
    @FindBy (id = "mat-select-value-1") WebElement securityqtnclick;
    @FindBy(xpath = "(//span[@class = 'mat-option-text'])[3]")WebElement selectingqtn;
    @FindBy (id = "securityAnswerControl") WebElement answerbtn;
    @FindBy (id = "registerButton") WebElement rgstrbtn;


    @Test
    public void registration() throws InterruptedException
    {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();

        PageFactory.initElements(driver,this);

        dismissbtn.click();
        emailbtn.sendKeys("dummy7@gmail.com");
        pswdbtn.sendKeys("juicershop1234!A");
        repeatpwdbtn.sendKeys("juicershop1234!A");
        securityqtnclick.click();
        selectingqtn.click();
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        answerbtn.sendKeys("june4");
        Thread.sleep(3000);
        rgstrbtn.click();

    }
}

