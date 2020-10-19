package com.booking.automation.tests;

		import com.booking.automation.commonMethods.commonMethods;
		import org.testng.annotations.AfterSuite;
		import org.testng.annotations.BeforeSuite;
		import org.testng.annotations.Parameters;
		import com.booking.automation.MyDriver;
		import com.booking.automation.pages.BookingHomePage;

public class BaseTests {

	MyDriver myDriver;
	private BookingHomePage _bookingHome;
	private commonMethods _commonMethods;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new MyDriver();
		_bookingHome = new BookingHomePage(myDriver.getDriver());
		_commonMethods = new commonMethods(myDriver.getDriver());
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		myDriver.dispose();
	}

	public BookingHomePage bookingHomePage() {
		return _bookingHome;
	}
	public commonMethods commonMethods() {
		return _commonMethods;
	}
}

