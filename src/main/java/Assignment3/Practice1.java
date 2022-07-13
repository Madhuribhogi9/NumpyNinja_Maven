package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice1
{
    WebDriver driver;

    @Test
    public void OpeningApp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://juice-shop.herokuapp.com/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }

    @Test
    public void creatinguser() throws InterruptedException
    {

        driver.findElement(By.xpath("//span[text() = 'Dismiss']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[text() = 'Not yet a customer?']")).click();
        driver.findElement(By.id("emailControl")).sendKeys("dummy5@gmail.com");
        driver.findElement(By.id("passwordControl")).sendKeys("juicershop1234!A");
        driver.findElement(By.id("repeatPasswordControl")).sendKeys("juicershop1234!A");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class = 'mat-form-field-infix ng-tns-c118-14']")).click();
        driver.findElement(By.xpath("(//span[@class = 'mat-option-text'])[3]")).click();
        driver.findElement(By.id("securityAnswerControl")).sendKeys("june4");
        driver.findElement(By.id("registerButton")).click();
    }

    @Test(priority = 1)
    public void login() throws InterruptedException
    {
        //driver.findElement(By.xpath("//span[text() = 'Dismiss']")).click();
        driver.findElement(By.id("email")).sendKeys("dummy5@gmail.com");
        driver.findElement(By.id("password")).sendKeys("juicershop1234!A");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void addingitemsintobasket() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text() = 'Me want it!']")).click();
        for (int i = 0; i <3 ; i++)
        {
            driver.findElement(By.xpath("(//mat-grid-tile//span[text() ='Add to Basket'])[2]")).click();
            Thread.sleep(3000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//mat-grid-tile//span[text() ='Add to Basket'])[5]")).click();

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//mat-grid-tile//span[text() ='Add to Basket'])[7]")).click();
            Thread.sleep(3000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
            driver.findElement(By.xpath("//button[@aria-label = 'Next page']")).click();
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1500)");

            }
        }
    @Test(priority = 3)
   public void increasingquantity() throws InterruptedException
   {
        driver.findElement(By.xpath("//button[@aria-label = 'Show the shopping cart']")).click();
        for (int i = 1; i <4 ; i++)
        {
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//mat-row//mat-cell[3]//button[2])["+i+"]")).click();
        }
        for (int i = 5; i <10; i++)
        {
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//mat-row//mat-cell[3]//button[2])["+i+"]")).click();
        }
        }
    @Test(priority = 4)
     public void checkoutandaddingnewadress() throws InterruptedException
     {
         Thread.sleep(3000);

         //Actions a = new Actions(driver);
         WebElement checkoutbtn = driver.findElement(By.xpath("//button[@id = 'checkoutButton']//span[@class = 'mat-button-wrapper']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutbtn);
         //a.moveToElement(driver.findElement(By.xpath("//button[@id = 'checkoutButton']//span[@class = 'mat-button-wrapper']"))).click();
         driver.findElement(By.xpath("//span[text()='Add New Address']")).click();
        driver.findElement(By.id("mat-input-9")).sendKeys("United States Of America");
        driver.findElement(By.id("mat-input-10")).sendKeys("dummy");
        driver.findElement(By.id("mat-input-11")).sendKeys("12345678");
        driver.findElement(By.id("mat-input-12")).sendKeys("532001");
        driver.findElement(By.id("address")).sendKeys("First and last name\n" +
                                                              "Company name, if applicable\n" +
                                                              "Street number and name\n" +
                                                              "City, state, and zip code\n" +
                                                              "\n" );
        driver.findElement(By.id("mat-input-14")).sendKeys("Hyderabad");
         driver.findElement(By.id("mat-input-15")).sendKeys("washington");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(3000);
        }
        @Test(priority = 5)
    public void selectingaddresssanddeliveryspeed() throws InterruptedException
        {
            driver.findElement(By.id("mat-radio-40")).click();
            driver.findElement(By.xpath("(//button[@color = 'primary'])[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//span[@class = 'mat-radio-container'])[1]")).click();
            driver.findElement(By.xpath("(//button[@color = 'primary'])")).click();
        }
        @Test(priority = 6)
       public void addingnewcard()
        {
        driver.findElement(By.id("mat-expansion-panel-header-0")).click();
        driver.findElement(By.id("mat-input-16")).sendKeys("user1");
        driver.findElement(By.id("mat-input-17")).sendKeys("1234567891012131");
        Select s = new Select(driver.findElement(By.id("mat-input-18")));
        s.selectByValue("2");
        Select s1 = new Select(driver.findElement(By.id("mat-input-19")));
        s1.selectByValue("2080");
        driver.findElement(By.id("submitButton")).click();
        }
        @Test(priority = 7)
        public void addingfakecouponandplacingorder() throws InterruptedException
        {

           WebElement couponbox = driver.findElement(By.id("mat-expansion-panel-header-1"));
            //Actions a = new Actions(driver);
            //a.moveToElement(driver.findElement(By.xpath("//mat-panel-title[text() = ' Add a coupon ']"))).click();
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", couponbox);
            driver.findElement(By.id("coupon")).sendKeys("1234567891");
            driver.findElement(By.id("applyCouponButton")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("(//span[@class = 'mat-radio-outer-circle'])[1]")).click();
            driver.findElement(By.xpath("//span[text() = 'Continue']")).click();
            driver.findElement(By.xpath("//span[text() = 'Place your order and pay']")).click();
        }
        @Test(priority = 8)
    public void logout()
        {
            driver.findElement(By.id("navbarAccount")).click();
            driver.findElement(By.id("navbarLogoutButton")).click();
        }


}