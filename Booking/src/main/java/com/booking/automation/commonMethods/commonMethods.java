package com.booking.automation.commonMethods;
import com.booking.automation.pages.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class commonMethods extends BasePage {

    public commonMethods(WebDriver driver) {
        super(driver);

    }

    public WebElement waitandfind(WebElement element){
        try
        {
            WebElement elementfound = fluentWait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element sucessfully found: "+elementfound);
            if(elementfound.isDisplayed()){
                return  elementfound;
            }
            else{
                return null;
            }

        }
        catch(Exception e) {
            System.out.println("Element not found: "+element);
            return null;
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
    public boolean isClickable(WebElement element){
        WebElement elementfound = waitandfind(element);
        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(elementfound));
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public void click(WebElement element){
        WebElement elementfound = waitandfind(element);
        try {
            if(elementfound.isDisplayed()){
                fluentWait.until(ExpectedConditions.elementToBeClickable(elementfound));
                elementfound.click();
                implicitwait(3);
                System.out.println("Element sucessfully clicked: "+elementfound);
            }
        }
        catch(Exception e) {
            System.out.println("Error On click: "+elementfound+" error: "+e);
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
        WebElement elementfound = waitandfind(element);
        try {
            if(elementfound.isDisplayed()){
                elementfound.sendKeys(text);
                implicitwait(3);
                System.out.println("sucessfully entertext: "+text+" + "+elementfound);
            }
        }
        catch(Exception e) {
            System.out.println("Error On enterText: "+text+" + "+elementfound+" error: "+e);
        }
    }
    public void implicitwait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public void selectCheckInDate(WebElement datePicker,int days){
        String[] dateWanted = getDayWanted(days);
        List<WebElement> columns = datePicker.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().contains(dateWanted[2])) {
                cell.click();
                break;
            }
        }
        implicitwait(4);
    }
    public String[] getDayWanted (int days){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal  = Calendar.getInstance(TimeZone.getDefault());
        cal.add(Calendar.DATE, +days);
        Date todate1 = cal.getTime();
        String[] date = dateFormat.format(todate1).split("-");
        return date;
    }


}
