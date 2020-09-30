package com.espn.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.espn.automation.pages.EspnHomePage;
import com.espn.automation.commonMethods.commonMethods;

import java.io.*;

public class EspnTests extends BaseTests {

	@Test(priority=1)
	public void testLogInPopUp() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		boolean isClickable = false;
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		Assert.assertEquals(_commonMethods.getMessages(_espnHomePage.logInPopUp),
				"Log In\n" +
						"Need help logging in?\n" +
						"Facebook Log In is no longer available. For help logging in, please use the link above.\n" +
						"Sign Up");
		_commonMethods.click(_espnHomePage.closeXIcon);
		_commonMethods.exitfromFrame();
	}
	@Test(priority=2)
	public void testSigUpPopUp() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		_commonMethods.click(_espnHomePage.SignUpbutton);
		Assert.assertEquals(_commonMethods.getMessages(_espnHomePage.SignInPopUp),"Create Account\n" +
				"Show password\n" +
				"Please send me occasional information and offers about my favorite teams, sports and other information from:\n" +
				"ESPN, ESPN+ and The Walt Disney Family of Companies\n" +
				"By creating an account, I agree to the Terms of Use and acknowledge that I have read the Privacy Policy.\n" +
				"My home country/region: Colombia. Change.\n" +
				"Sign Up\n" +
				"Already have an account? Log In");
		_commonMethods.click(_espnHomePage.closeXIcon);
		_commonMethods.exitfromFrame();
	}
	@Test(priority=3)
	public void createAccount(){
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String firstName="Alejandro";
		String lastName="Areiza";
		String email=_commonMethods.randomEmail();
		String password="HelloWorld1!";
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		_commonMethods.click(_espnHomePage.SignUpbutton);
		_commonMethods.enterText(firstName,_espnHomePage.firstName);
		_commonMethods.enterText(lastName,_espnHomePage.lastName);
		_commonMethods.enterText(email,_espnHomePage.email);
		_commonMethods.enterText(password,_espnHomePage.password);
		_commonMethods.click(_espnHomePage.SignUpConfirmationButton);
		_commonMethods.exitfromFrame();
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.userIcon));
		_commonMethods.click(_espnHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.logoutOption));
		_commonMethods.click(_espnHomePage.logoutOption);
		_commonMethods.writeCredentails(email,password);
	}
	@Test(priority=4)
	public void testLogIn() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		_commonMethods.enterText(credentials[1],_espnHomePage.userName);
		_commonMethods.enterText(credentials[2],_espnHomePage.signInPassword);
		_commonMethods.click(_espnHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_espnHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.logoutOption));
		_commonMethods.click(_espnHomePage.logoutOption);
	}
	@Test(priority=5)
	public void testLogOut() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		_commonMethods.enterText(credentials[1],_espnHomePage.userName);
		_commonMethods.enterText(credentials[2],_espnHomePage.signInPassword);
		_commonMethods.click(_espnHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.logoutOption);
		_commonMethods.click(_espnHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.loginOption));
		_commonMethods.click(_espnHomePage.userIcon);
	}

	@Test(priority=6)
	public void deleteAccount() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.deleteAccountFrame);
		_commonMethods.enterText(credentials[3],_espnHomePage.userName);
		_commonMethods.enterText(credentials[4],_espnHomePage.signInPassword);
		_commonMethods.click(_espnHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_espnHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.espnProfile));
		_commonMethods.click(_espnHomePage.espnProfile);
		_commonMethods.changetoFrame(_espnHomePage.deleteAccountFrame);
		_commonMethods.click(_espnHomePage.deleteAccount);
		_commonMethods.click(_espnHomePage.deleteAccountConfirmation);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_espnHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_espnHomePage.loginOption));
		_commonMethods.click(_espnHomePage.userIcon);
	}
	@Test(priority=7)
	public void Accounteactivated() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changetoFrame(_espnHomePage.logInFrame);
		_commonMethods.enterText(credentials[3],_espnHomePage.userName);
		_commonMethods.enterText(credentials[4],_espnHomePage.signInPassword);
		_commonMethods.click(_espnHomePage.logInButton);
		Assert.assertTrue(_commonMethods.getMessages(_espnHomePage.AccountDeactivated).contains("Account Deactivated"));

	}

}
