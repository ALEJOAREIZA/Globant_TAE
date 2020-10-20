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
    @FindBy(css="div.hprt-reservation-cta button[type=\"submit\"]")
    public WebElement bookedButton;

    @FindBy(css="[class=\"hprt-reservation-cta\"]")
    public WebElement bookedButton2;



    public String bookedButtonString = "div.hprt-reservation-cta button[type=\"submit\"]";

    @FindBy(css="[data-placeholder=\"Fecha de entrada\"]")
    public WebElement checkInDate;
    @FindBy(css="[data-placeholder=\"Fecha de salida\"]")
    public WebElement checkOutDate;

    @FindBy(css="#hprt-table tr:nth-child(1) td:nth-child(5) [class=\"hprt-block\"]:first-child")
    public WebElement rooms;

    @FindBy(css="#hprt-table tr:nth-child(1) td:nth-child(5) [class=\"hprt-block\"]:first-child select option:nth-child(2)")
    public WebElement rooms1;




}
