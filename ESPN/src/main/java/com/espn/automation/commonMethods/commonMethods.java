package com.espn.automation.commonMethods;
import com.espn.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

public class commonMethods extends BasePage {

    public commonMethods(WebDriver driver) {
        super(driver);
    }



    public WebElement waitandfind(WebElement element)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            return  element;
        }
        catch(Exception e) {
            Logger.getLogger("Element not found " +e);
            return null;
        }
    }

    public void click(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            elementfound.click();
        }
        catch(Exception e) {
            Logger.getLogger("Error on click"+e);
        }
    }

    public String getMessages(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            return elementfound.getText();
        }
        catch(Exception e) {
            Logger.getLogger("Error on click"+e);
            return null;
        }
    }
}
