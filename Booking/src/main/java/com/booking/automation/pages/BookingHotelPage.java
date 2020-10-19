package com.booking.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingHotelPage extends BasePage{
    public BookingHotelPage(WebDriver pDriver) {
        super(pDriver);
    }
    @FindBy(id="hp_hotel_name")
    public WebElement hotelTitle;

    @FindBy(css="[class=\"bui-price-display__label \"]")
    public WebElement bookedInfo;

    @FindBy(css="td.totalPrice [class=\"bui-price-display__value prco-inline-block-maker-helper\"]")
    public WebElement bookedhotelPrice;

    public String hotelTitleString= "#hp_hotel_name";

}
