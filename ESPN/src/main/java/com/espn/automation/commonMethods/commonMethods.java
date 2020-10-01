package com.espn.automation.commonMethods;
import com.espn.automation.pages.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class commonMethods extends BasePage {

    public commonMethods(WebDriver driver) {
        super(driver);

    }

    public String randomEmail(){
        Faker faker = new Faker();
        return faker.name().firstName()+"_"+faker.name().lastName()+ "@tae.com";
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
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);            
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
    public void writeCredentails(String email, String password){
        try {
            FileWriter myWriter = new FileWriter("credentials.txt",true);
            myWriter.append("\n");
            myWriter.write(email);
            myWriter.append("\n");
            myWriter.write(password);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing credentials: "+e);
        }

    }
    public String readCredentails(){
        try {
            String data = "";
            return data = new String(Files.readAllBytes(Paths.get("credentials.txt")));
        }
        catch (IOException e) {
            System.out.println("Error reading credentials: "+e);
            return null;
        }
    }
    public void createCredentails(){
        try {
            File credentials = new File("credentials.txt");
            if (credentials.createNewFile()) {
                System.out.println("File created: " + credentials.getName());
            } else {
                System.out.println("File already exists.");
            }
            writeCredentails("globant_tae2@tae.com","HelloWorld1!");
        } catch (IOException e) {
            System.out.println("An error occurred."+e);
            e.printStackTrace();
        }
    }
    public void deleteCredentails(){
        File credentials = new File("credentials.txt");
        if (credentials.delete()) {
            System.out.println("Deleted the file: " + credentials.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

    }



}
