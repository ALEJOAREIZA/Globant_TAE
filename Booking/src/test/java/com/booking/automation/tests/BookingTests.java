package com.booking.automation.tests;

import com.booking.automation.commonMethods.commonMethods;
import com.booking.automation.pages.BookingHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests extends BaseTests {

	@Test(priority=1)
	public void testLogInPopUp() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		boolean isClickable = false;
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.logInPopUp),
				"Log In\n" +
						"Need help logging in?\n" +
						"Facebook Log In is no longer available. For help logging in, please use the link above.\n" +
						"Sign Up");
		_commonMethods.click(_bookingHomePage.closeXIcon);
		_commonMethods.exitfromFrame();
	}
	@Test(priority=2)
	public void testSigUpPopUp() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		_commonMethods.click(_bookingHomePage.SignUpbutton);
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.SignInPopUp),"Create Account\n" +
				"Show password\n" +
				"Please send me occasional information and offers about my favorite teams, sports and other information from:\n" +
				"ESPN, ESPN+ and The Walt Disney Family of Companies\n" +
				"By creating an account, I agree to the Terms of Use and acknowledge that I have read the Privacy Policy.\n" +
				"My home country/region: Colombia. Change.\n" +
				"Sign Up\n" +
				"Already have an account? Log In");
		_commonMethods.click(_bookingHomePage.closeXIcon);
		_commonMethods.exitfromFrame();
	}
	@Test(priority=3)
	public void createAccount(){
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		String firstName="Alejandro";
		String lastName="Areiza";
		String email=_commonMethods.randomEmail();
		String password="HelloWorld1!";
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		_commonMethods.click(_bookingHomePage.SignUpbutton);
		_commonMethods.enterText(firstName, _bookingHomePage.firstName);
		_commonMethods.enterText(lastName, _bookingHomePage.lastName);
		_commonMethods.enterText(email, _bookingHomePage.email);
		_commonMethods.enterText(password, _bookingHomePage.password);
		_commonMethods.click(_bookingHomePage.SignUpConfirmationButton);
		_commonMethods.exitfromFrame();
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.userIcon));
		_commonMethods.click(_bookingHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.logoutOption));
		_commonMethods.click(_bookingHomePage.logoutOption);
		_commonMethods.writeCredentails(email,password);
	}
	@Test(priority=4)
	public void testLogIn() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		_commonMethods.enterText(credentials[1], _bookingHomePage.userName);
		_commonMethods.enterText(credentials[2], _bookingHomePage.signInPassword);
		_commonMethods.click(_bookingHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_bookingHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.logoutOption));
		_commonMethods.click(_bookingHomePage.logoutOption);
	}
	@Test(priority=5)
	public void testLogOut() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		_commonMethods.enterText(credentials[1], _bookingHomePage.userName);
		_commonMethods.enterText(credentials[2], _bookingHomePage.signInPassword);
		_commonMethods.click(_bookingHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.logoutOption);
		_commonMethods.click(_bookingHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.loginOption));
		_commonMethods.click(_bookingHomePage.userIcon);
	}

	@Test(priority=6)
	public void deleteAccount() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.deleteAccountFrame);
		_commonMethods.enterText(credentials[3], _bookingHomePage.userName);
		_commonMethods.enterText(credentials[4], _bookingHomePage.signInPassword);
		_commonMethods.click(_bookingHomePage.logInButton);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_bookingHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.bookingProfile));
		_commonMethods.click(_bookingHomePage.bookingProfile);
		_commonMethods.changetoFrame(_bookingHomePage.deleteAccountFrame);
		_commonMethods.click(_bookingHomePage.deleteAccount);
		_commonMethods.click(_bookingHomePage.deleteAccountConfirmation);
		_commonMethods.click(_bookingHomePage.deleteAccountConfirmationclose);
		_commonMethods.exitfromFrame();
		_commonMethods.click(_bookingHomePage.userIcon);
		Assert.assertTrue(_commonMethods.isClickable(_bookingHomePage.loginOption));
		_commonMethods.click(_bookingHomePage.userIcon);
	}
	@Test(priority=7)
	public void Accounteactivated() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		String[] credentials = _commonMethods.readCredentails().split("\n");
		_commonMethods.click(_bookingHomePage.userIcon);
		_commonMethods.click(_bookingHomePage.loginOption);
		_commonMethods.changetoFrame(_bookingHomePage.logInFrame);
		_commonMethods.enterText(credentials[3], _bookingHomePage.userName);
		_commonMethods.enterText(credentials[4], _bookingHomePage.signInPassword);
		_commonMethods.click(_bookingHomePage.logInButton);
		Assert.assertTrue(_commonMethods.getMessages(_bookingHomePage.AccountDeactivated).contains("Account Deactivated"));

	}

}
