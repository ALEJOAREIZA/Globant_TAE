package com.shopping.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="[class=\"product_title entry-title\"]")
    public WebElement productTitle;
    @FindBy(css="div.summary [class=\"price\"]")
    public WebElement productPrice;

    @FindBy(css="div.summary [class=\"quantity\"] input")
    public WebElement productQuantity;

    @FindBy(name="add-to-cart")
    public WebElement addtocartButton;

    @FindBy(css="[class=\"woocommerce-message\"] ")
    public WebElement addedtocartMessage;

    @FindBy(css="[class=\"woocommerce-message\"] a")
    public WebElement gotoCart;

    @FindBy(id="site-header-cart")
    public WebElement cartIcon;

    @FindBy(css="td[class=\"product-name\"]")
    public WebElement productNameList;

    @FindBy(css="td[class=\"product-price\"]")
    public WebElement producPriceList;

    @FindBy(css="td[class=\"product-quantity\"] input")
    public WebElement productQuantityList;




}