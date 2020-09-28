package com.espn.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.espn.automation.pages.AppPage;
import com.espn.automation.pages.EspnHomePage;

public class EspnTests extends BaseTests {
	

	
	@Test
	public void testEspnTitle() {
		EspnHomePage home = getEspnHomePage();
		Assert.assertEquals(home.getPageTitle(), "ESPN");
	}

}
