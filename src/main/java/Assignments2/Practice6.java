package Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice6
{
    WebDriver driver;
    @BeforeMethod
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }
    @Test
    public void Shopping() throws InterruptedException
    {

       driver.findElement(By.id("search_query_top")).sendKeys("summer dress");
       driver.findElement(By.name("submit_search")).click();
       driver.findElement(By.xpath("(//li//img[@class= 'replace-2x img-responsive'])[9]")).click();
       driver.findElement(By.xpath("//span[text() = 'Add to cart']")).click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
       WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
       wait.until(ExpectedConditions.visibilityOf(ele)).click();

       driver.findElement(By.xpath("(//a[@title = 'T-shirts'])[2]")).click();
        Actions a = new Actions(driver);
        WebElement Mousehover = driver.findElement(By.xpath("//img[@title = 'Faded Short Sleeve T-shirts']"));
        a.moveToElement(Mousehover).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class = 'add_to_compare']")))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[text()='Dresses'])[2]")).click();
        Thread.sleep(3000);
        WebElement mousehover1 = driver.findElement(By.xpath("(//img[@title = 'Printed Dress'])[2]"));
        Thread.sleep(3000);
        a.moveToElement(mousehover1).perform();
        Thread.sleep(3000);
       JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement comparebtn2 = driver.findElement(By.xpath("(//li//div//a[@class = 'add_to_compare'])[2]"));
       js.executeScript("arguments[0].click();",comparebtn2);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li//div//a[@class = 'add_to_compare'])[2]")))).click();
        driver.findElement(By.xpath("//div[@class = 'content_sortPagiBar clearfix']//span[contains(text() ,'Compare (')]")).click();
        driver.findElement(By.xpath("(//i[@class = 'icon-trash'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
        WebElement checkout = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.visibilityOf(checkout)).click();

        driver.findElement(By.xpath("//span[text() ='Proceed to checkout']")).click();
        driver.findElement(By.name("email_create")).sendKeys("dummy960.30@gmail.com");
        driver.findElement(By.xpath("//span//i[@class ='icon-user left']")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("dummy");
        driver.findElement(By.id("customer_lastname")).sendKeys("dummy");
        driver.findElement(By.id("passwd")).sendKeys("1234556");

        //driver.findElement(By.id("firstname")).sendKeys("dummy");
        //driver.findElement(By.id("lastname")).sendKeys("dummy");
        driver.findElement(By.id("address1")).sendKeys("Street address, P.O. Box, Company name");
        driver.findElement(By.id("city")).sendKeys("redmond");
        WebElement State = driver.findElement(By.id("id_state"));
        Select s = new Select(State);
        s.selectByValue("47");
        driver.findElement(By.id("postcode")).sendKeys("12345");
       WebElement country= driver.findElement(By.id("id_country"));
        Select s1 = new Select(country);
        s1.selectByValue("21");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345678910");
        Thread.sleep(3000);
        //driver.findElement(By.id("//span[text() = 'Register']")).click();
       WebElement registerbtn =  driver.findElement(By.xpath("//span[text() = 'Register']"));
       js.executeScript("arguments[0].click();",registerbtn);
       //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("//span[text() = 'Register']")))).click();
       //registerbtn.click();

        driver.findElement(By.xpath("//span[text() = 'Proceed to checkout']")).click();

        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//button//span[contains(text(), 'Proceed to checkout')]")).click();

        driver.findElement(By.xpath("//a[contains(text() , 'Pay by check')] ")).click();

        driver.findElement(By.xpath("//span[text() = 'I confirm my order']")).click();
        driver.findElement(By.xpath("(//div//a//span)[1]")).click();
        driver.findElement(By.xpath("//span[text() = 'Order history and details']")).click();
        driver.findElement(By.xpath("//a[@class = 'logout']")).click();

    }
}
