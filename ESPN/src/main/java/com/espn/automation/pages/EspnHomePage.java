package com.espn.automation.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EspnHomePage extends BasePage{

	public EspnHomePage(WebDriver driver) {
		super(driver);
		//driver.get("https://www.espn.com/?src=com&_adblock=true");
	}

	@FindBy(id="global-user-trigger")
	public WebElement userIcon;

	@FindBy(css="#global-user-trigger + .global-user > .global-user-container > .account-management [tref=\"/members/v3_1/login\"]")
	public WebElement loginOption;

	@FindBy(id="did-ui-view")
	public WebElement logInPopUp;

	@FindBy(id="did-ui-view")
	public WebElement SignInPopUp;

	@FindBy(id="disneyid-iframe")
	public WebElement logInFrame;

	@FindBy(id="close")
	public WebElement closeXIcon;

	@FindBy(css="[ng-click=\"vm.createAccount()\"]")
	public WebElement signUpButton;

	@FindBy(css="[name=firstName]")
	public WebElement firstName;

	@FindBy(css="[name=lastName]")
	public WebElement lastName;

	@FindBy(css="[name=email]")
	public WebElement email;

	@FindBy(css="[name=newPassword]")
	public WebElement password;

	@FindBy(css="div.btn-group")
	public WebElement SignUpbutton;

	@FindBy(css="#global-user-trigger + .global-user > .global-user-container > .account-management [class=\"small\"]")
	public WebElement logoutOption;





}
