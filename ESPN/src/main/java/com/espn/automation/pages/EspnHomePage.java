package com.espn.automation.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EspnHomePage extends BasePage{

	public EspnHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.espn.com/?src=com&_adblock=true\"");
	}

	@FindBy(id="global-user-trigger")
	public WebElement userIcon;

	@FindBy(css="#global-user-trigger + .global-user > .global-user-container > .account-management [tref=\"/members/v3_1/login\"]")
	public WebElement loginOption;

	@FindBy(id="did-ui-view")
	public WebElement logInPopUp;

	@FindBy(id="disneyid-iframe")
	public WebElement logInFrame;



}
