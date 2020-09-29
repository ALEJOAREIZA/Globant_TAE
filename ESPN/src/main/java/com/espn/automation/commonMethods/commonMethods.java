package com.espn.automation.commonMethods;
import com.espn.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
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
            System.out.println("Element not found: "+e);
            return null;
        }
    }

    public void click(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            elementfound.click();
        }
        catch(Exception e) {
            System.out.println("Error On click: "+e);
        }
    }

    public String getMessages(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            return elementfound.getText();
        }
        catch(Exception e) {
            System.out.println("Error on GetMessages: "+e);
            return null;
        }
    }

    public String getCurrentWindow()
    {
        return driver.getCurrentUrl();        //return alert.getText();
    }

    public void changeFrame(WebElement frame)
    {
        driver.switchTo().frame(frame);

    }

    public void changeWindow(String window)
    {
        driver.switchTo().window(window);
    }

    public void myassert(String expectedMessage,String currentMessage)
    {
        Assert.assertEquals(expectedMessage, currentMessage);
        if (expectedMessage==currentMessage){
            System.out.println("test passed :D ");
            System.out.println("expected Message: "+expectedMessage);
            System.out.println("current Message: "+currentMessage);
        }
        else{
            System.out.println("test failed :( ");
            System.out.println("expected Message: "+expectedMessage);
            System.out.println("current Message: "+currentMessage);
        }

    }


}
