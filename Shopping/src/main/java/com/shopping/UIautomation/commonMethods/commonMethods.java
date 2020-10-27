package com.shopping.UIautomation.commonMethods;
import com.shopping.UIautomation.pages.BasePage;
import com.shopping.UIautomation.waits.waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class commonMethods extends BasePage {

    public commonMethods(WebDriver driver) {
        super(driver);

    }

    waits wait = new waits(driver);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public WebElement waitandfind(WebElement element){
        try
        {
            WebElement elementfound = wait.fluentWait.until(ExpectedConditions.visibilityOf(element));
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
    public void click(WebElement element){
        WebElement elementfound = waitandfind(element);
        try {
            if(elementfound.isDisplayed()){
                wait.fluentWait.until(ExpectedConditions.elementToBeClickable(elementfound));
                elementfound.click();
                wait.implicitwait(3);
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
    public void enterText(String text,WebElement element){
        WebElement elementfound = waitandfind(element);
        try {
            if(elementfound.isDisplayed()){
                elementfound.clear();
                elementfound.sendKeys(text);
                wait.implicitwait(3);
                System.out.println("sucessfully entertext: "+text+" + "+elementfound);
            }
        }
        catch(Exception e) {
            System.out.println("Error On enterText: "+text+" + "+elementfound+" error: "+e);
        }
    }
    public Date selectCheckInDate(WebElement datePicker,int daysnumber){
        Date checkInDate = todaysDate(daysnumber);
        String cssSelector = buildingSelector(checkInDate);
        boolean flag = true;
        while(flag){
            List<WebElement> days = datePicker.findElements(By.tagName("td"));
            for (int j = 0; j <days.size() ; j++) {
                try {
                    if (datePicker.findElement(By.cssSelector(cssSelector)).isDisplayed())
                    {
                        flag=false;
                        datePicker.findElement(By.cssSelector(cssSelector)).click();
                        break;
                    }
                } catch(Exception e) {
                    break;
                }
            }
            if(flag){
                WebElement next = datePicker.findElement(By.cssSelector("[data-bui-ref=\"calendar-next\"]"));
                next.click();
            }
        }
        wait.implicitwait(4);
        return checkInDate;
    }
    public Date selectCheckOutDate(WebElement datePicker,Date checkInDate,int daysnumber){
        Date checkOutDate = dateFormat(checkInDate,daysnumber);
        String cssSelector = buildingSelector(checkOutDate);
        boolean flag = true;
        while(flag){
            List<WebElement> days = datePicker.findElements(By.tagName("td"));
            for (int j = 0; j <days.size() ; j++) {
                try {
                    if (datePicker.findElement(By.cssSelector(cssSelector)).isDisplayed())
                    {
                        flag=false;
                        datePicker.findElement(By.cssSelector(cssSelector)).click();
                        break;
                    }
                } catch(Exception e) {
                    break;
                }
            }
            if(flag){
                WebElement next = datePicker.findElement(By.cssSelector("[data-bui-ref=\"calendar-next\"]"));
                next.click();
            }

        }
        wait.implicitwait(4);
        return checkOutDate;
    }
    private Date todaysDate (int days){

        Calendar cal  = Calendar.getInstance(TimeZone.getDefault());
        cal.add(Calendar.DATE, +days);
        Date todaysDate = cal.getTime();
        String[] date = dateFormat.format(todaysDate).split("-");
        return todaysDate;
    }
    public String getPageContext(){
        return driver.getWindowHandle();
    }
    public void switchPage(int page){
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(page-1).toString());
    }
    private Date dateFormat (Date date,int days){
        Calendar cal  = Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(date);
        cal.add(Calendar.DATE,days);
        return cal.getTime();
    }
    private String buildingSelector(Date date){
        String datewanted = dateFormat.format(date);
       return "[class=\"bui-calendar\"] td[data-date=\""+datewanted+"\"]";
    }
    public String datetoDateString(Date date){
        Calendar cal  = Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(date);
        Date todaysDate = cal.getTime();
        return dateFormat.format(todaysDate);
    }

    public void sendKeys(String text,WebElement element){
        WebElement elementfound = waitandfind(element);
        try {
            if(elementfound.isDisplayed()){
                elementfound.sendKeys(text);
                wait.implicitwait(3);
                System.out.println("sucessfully entertext: "+text+" + "+elementfound);
            }
        }
        catch(Exception e) {
            System.out.println("Error On enterText: "+text+" + "+elementfound+" error: "+e);
        }
    }

}
