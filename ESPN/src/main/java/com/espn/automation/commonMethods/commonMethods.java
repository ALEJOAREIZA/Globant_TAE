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



    public WebElement waitandfind(WebElement element){
        try
        {
            WebElement elementfound = wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element sucessfully found: "+elementfound);
            return  elementfound;
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
    public boolean isDisplayed(WebElement element){
        if(waitandfind(element).isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
    public void click(WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            wait = new WebDriverWait(driver, 10);
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable((elementfound)));
            el.click();
            //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }
        catch(Exception e) {
            System.out.println("Error On click: "+element+" error: "+e);
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
    public void changetoFrame(WebElement frame){
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
    public void enterText(String text,WebElement element){
        try {
            WebElement elementfound = waitandfind(element);
            elementfound.sendKeys(text);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        catch(Exception e) {
            System.out.println("Error On enterText: "+element);
        }
    }



}
