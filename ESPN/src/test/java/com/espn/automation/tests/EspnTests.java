package com.espn.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.espn.automation.pages.EspnHomePage;
import com.espn.automation.commonMethods.commonMethods;

public class EspnTests extends BaseTests {


	@Test
	public void testLogInPopUp() {
		EspnHomePage _espnHomePage = espnHomePage();
		commonMethods _commonMethods = commonMethods();
		String homeWindow = _commonMethods.getCurrentWindow();
		_commonMethods.click(_espnHomePage.userIcon);
		_commonMethods.click(_espnHomePage.loginOption);
		_commonMethods.changeFrame(_espnHomePage.logInFrame);
		Assert.assertEquals(_commonMethods.getMessages(_espnHomePage.logInPopUp),
				"Log In\n" +
				"Need help logging in?\n" +
				"Facebook Log In is no longer available. For help logging in, please use the link above.\n" +
				"Sign Up");
	}
//	@Test
//	public void test1(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test2(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test3(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test4(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test5(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test6(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test7(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test8(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test9(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}
//	@Test
//	public void test10(){
//		EspnHomePage home = getEspnHomePage();
//		Assert.assertEquals(home.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
//	}


}
