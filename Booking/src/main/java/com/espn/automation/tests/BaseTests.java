package com.espn.automation.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.espn.automation.MyDriver;
import com.espn.automation.pages.EspnHomePage;
import com.espn.automation.commonMethods.commonMethods;

public class BaseTests {
	
	MyDriver myDriver;
	private EspnHomePage espnHome;
	private commonMethods _commonMethods;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		espnHome = new EspnHomePage(myDriver.getDriver());
		_commonMethods = new commonMethods(myDriver.getDriver());
		_commonMethods.createCredentails();
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {

		espnHome.dispose();
		_commonMethods.deleteCredentails();
	}

	public EspnHomePage espnHomePage() {
		return espnHome;
	}
	public commonMethods commonMethods() {
		return _commonMethods;
	}
}
