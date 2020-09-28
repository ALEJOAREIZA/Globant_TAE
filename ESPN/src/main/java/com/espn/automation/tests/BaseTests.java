package com.espn.automation.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.espn.automation.MyDriver;
import com.espn.automation.pages.EspnHomePage;

public class BaseTests {
	
	MyDriver myDriver;
	private EspnHomePage espnHome;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		espnHome = new EspnHomePage(myDriver.getDriver());
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		espnHome.dispose();
	}

	public EspnHomePage getEspnHomePage() {
		return espnHome;
	}
}
