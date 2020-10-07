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

	@FindBy(id="did-ui-view")
	public WebElement AccountDeactivated;

	@FindBy(id="disneyid-iframe")
	public WebElement logInFrame;

	@FindBy(id="disneyid-iframe")
	public WebElement deleteAccountFrame;

	@FindBy(id="close")
	public WebElement closeXIcon;

	@FindBy(css="[ng-click=\"vm.createAccount()\"]")
	public WebElement SignUpbutton;

	@FindBy(css="[name=firstName]")
	public WebElement firstName;

	@FindBy(css="[name=lastName]")
	public WebElement lastName;

	@FindBy(css="[name=email]")
	public WebElement email;

	@FindBy(css="[name=newPassword]")
	public WebElement password;

	@FindBy(css="div.btn-group")
	public WebElement SignUpConfirmationButton;

	@FindBy(css="#global-user-trigger + .global-user > .global-user-container > .account-management [class=\"small\"]")
	public WebElement logoutOption;

	@FindBy(css="[ng-model=\"vm.username\"]")
	public WebElement userName;

	@FindBy(css="[ng-model=\"vm.password\"]")
	public WebElement signInPassword;

	@FindBy(css="[ng-click=\"vm.submitLogin()\"]")
	public WebElement logInButton;

	@FindBy(css="#global-user-trigger + .global-user > .global-user-container > .account-management [tref=\"/members/v3_1/modifyAccount\"]")
	public WebElement espnProfile;

	@FindBy(id="cancel-account")
	public WebElement deleteAccount;

	@FindBy(css="[ng-click=\"vm.confirm()\"]")
	public WebElement deleteAccountConfirmation;

	@FindBy(css="ng-click=\"vm.close()\"")
	public WebElement deleteAccountConfirmationclose;








}
