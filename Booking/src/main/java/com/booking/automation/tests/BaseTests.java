package com.booking.automation.tests;

import com.booking.automation.commonMethods.commonMethods;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.booking.automation.MyDriver;
import com.booking.automation.pages.BookingHomePage;

public class BaseTests {
	
	MyDriver myDriver;
	private BookingHomePage bookingHome;
	private commonMethods _commonMethods;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		bookingHome = new BookingHomePage(myDriver.getDriver());
		_commonMethods = new commonMethods(myDriver.getDriver());
		_commonMethods.createCredentails();
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {

		bookingHome.dispose();
		_commonMethods.deleteCredentails();
	}

	public BookingHomePage bookingHomePage() {
		return bookingHome;
	}
	public commonMethods commonMethods() {
		return _commonMethods;
	}
}
