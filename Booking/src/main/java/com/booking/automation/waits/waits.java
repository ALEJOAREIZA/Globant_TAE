package com.booking.automation.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class waits {

    private WebDriver driver;
    public Wait<WebDriver> fluentWait;

    public waits(WebDriver pDriver) {
        driver = pDriver;
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public void implicitwait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);
    }
    public  Boolean waitToDesappear(String locator) {
        try {
            fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public Boolean waitToAppear(String locator) {
        try {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
