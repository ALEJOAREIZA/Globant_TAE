package com.booking.automation.tests;

		import com.booking.automation.commonMethods.commonMethods;
		import com.booking.automation.pages.BookingHotelPage;
		import com.booking.automation.pages.BookingSearchPage;
		import org.testng.annotations.AfterSuite;
		import org.testng.annotations.BeforeSuite;
		import org.testng.annotations.Parameters;
		import com.booking.automation.MyDriver;
		import com.booking.automation.pages.BookingHomePage;

		import java.awt.print.Book;

public class BaseTests {

	MyDriver myDriver;
	private BookingHomePage _bookingHome;
	private commonMethods _commonMethods;
	private BookingSearchPage _bookingSearch;
	private BookingHotelPage _bookingHotelPage;
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new MyDriver();
		_bookingHome = new BookingHomePage(myDriver.getDriver());
		_bookingSearch = new BookingSearchPage(myDriver.getDriver());
		_commonMethods = new commonMethods(myDriver.getDriver());
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		myDriver.dispose();
	}

	public BookingHomePage bookingHomePage() {
		return _bookingHome;
	}
	public BookingSearchPage bookingSearchPage() {
		return _bookingSearch;
	}
	public BookingHotelPage bookingHotelPage(){return _bookingHotelPage;}
	public commonMethods commonMethods() {
		return _commonMethods;
	}
}

