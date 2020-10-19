package com.booking.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingSearchPage extends BasePage{

    public BookingSearchPage(WebDriver pDriver) {
        super(pDriver);
    }



    @FindBy(css="#filter_class [data-id=\"class-5\"]")
    public WebElement filterFiveStars;

    @FindBy(css="#hotellist_inner [data-hotelid]:nth-child(2)")
    public WebElement secondHotel;

    @FindBy(css="#hotellist_inner [data-hotelid]:nth-child(2) div > h3 span:first-child")
    public WebElement secondHotelTitle;

    @FindBy(css="#hotellist_inner [data-hotelid]:nth-child(2) [class=\"bui-review-score__badge\"]")
    public WebElement secondHotelScore;

    @FindBy(css="#hotellist_inner [data-hotelid]:nth-child(2) [class=\"bui-price-display__value prco-inline-block-maker-helper\"]")
    public WebElement secondHotelPrice;

    @FindBy(css="#hotellist_inner [data-hotelid]:nth-child(2) [class=\"txp-cta bui-button bui-button--primary sr_cta_button\"]")
    public WebElement secondHotelChooseButton;

    @FindBy(css="[class=\"sr-usp-overlay__container is_stuck\"]")
    public WebElement loading;

    public String loadingString = "[class=\"sr-usp-overlay__container is_stuck\"]";
    public String secondHotelChooseButtonString = "#hotellist_inner [data-hotelid]:nth-child(3) [class=\"txp-cta bui-button bui-button--primary sr_cta_button\"]";

}
