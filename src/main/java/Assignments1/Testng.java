package Assignments1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Testng
{
    WebDriver driver;
    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforemethod(String browser,String app)
    {
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(app);
        }
        else if (browser.equals("firefox"))

        {
            System.out.println("executing before method which is firefox");
        }
    }
    @Test
    public void test()
    {
        System.out.println(driver.getTitle());
    }


}
