package com.espn.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.espn.automation.pages.EspnHomePage;

public class EspnTests extends BaseTests {

	
	@Test
	public void testEspnLogin() {
		EspnHomePage home = getEspnHomePage();
		home.login();
		//Assert.assertEquals(EspnHomePage.getPageTitle(), "ESPN: Serving sports fans. Anytime. Anywhere.");
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
