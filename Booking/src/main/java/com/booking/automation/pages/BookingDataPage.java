package com.booking.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingDataPage extends BasePage {
    public BookingDataPage(WebDriver pDriver) {
        super(pDriver);
    }
    @FindBy(id="firstname")
    public WebElement firstname;
    @FindBy(id="lastname")
    public WebElement lastname;
    @FindBy(id="email")
    public WebElement email;
    @FindBy(id="email_confirm")
    public WebElement email_confirm;
    @FindBy(css="div.bui-group__item [type=\"submit\"]")
    public WebElement submitButton;
    @FindBy(id="phone")
    public WebElement phone;





}
