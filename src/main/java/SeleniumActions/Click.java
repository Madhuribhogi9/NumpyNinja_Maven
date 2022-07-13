package SeleniumActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Click
{
    WebDriver driver;
    public boolean click(WebElement element)
    {
        Wait<WebDriver> waits = new FluentWait<WebDriver>(driver);
        try{
            WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        if(ele.isDisplayed())
        {
            if(ele.isEnabled())
            {
                try
                {
                    Actions a = new Actions(driver);
                    a.moveToElement(ele);
                    a.click();
                    return true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else {
                throw new Exception("Element is not enabled");
            }
        }
        else {
            throw new Exception("Element is not displayed");

        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;


    }
}
