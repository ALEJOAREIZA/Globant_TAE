package com.espn.automation.commonMethods;
import com.espn.automation.pages.BasePage;
import org.apache.xpath.objects.XNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;
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
            System.out.println("Element not found: "+element);
            return null;
        }
    }

    public boolean isClickable(WebElement element){
        WebElement elementfound = waitandfind(element);
        if(elementfound.isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(elementfound));
            return true;
        }
        else{
            return false;
        }
    }

    public void click(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(elementfound));
            el.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Thread.sleep(2000);
        }
        catch(Exception e) {
            System.out.println("Error On click: "+element);
        }
    }

    public String getMessages(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            return elementfound.getText();
        }
        catch(Exception e) {
            System.out.println("Error on GetMessages: "+element);
            return null;
        }
    }

    public void changetoFrame(WebElement frame)
    {
        try {
            WebElement elementfound = waitandfind(frame);
            driver.switchTo().frame(elementfound);
        }
        catch(Exception e) {
            System.out.println("Error on changetoFrame: "+frame);
        }
    }

    public void exitfromFrame()
    {
      driver.switchTo().defaultContent();
    }




}
