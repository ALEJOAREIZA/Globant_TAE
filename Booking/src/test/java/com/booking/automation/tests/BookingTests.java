package com.booking.automation.tests;

import com.booking.automation.asserts.bookingAssert;
import com.booking.automation.commonMethods.commonMethods;
import com.booking.automation.pages.BookingDataPage;
import com.booking.automation.pages.BookingHomePage;
import com.booking.automation.pages.BookingHotelPage;
import com.booking.automation.pages.BookingSearchPage;
import com.booking.automation.waits.waits;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Date;

public class BookingTests extends BaseTests {

	@Test(priority=1)
	public void testPageOne() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		int  checkinDatecounter=30;
		int  checkoutDateCounter=15;
		int adultsNumberWanted=3;
		int childrenNumberWanted=1;
		int roomsNumberWanted=1;
		String bogota= "Bogotá, Colombia";
		_commonMethods.click(_bookingHomePage.tabAccomodations);
		_commonMethods.enterText(bogota,_bookingHomePage.inputDestination);
		_commonMethods.click(_bookingHomePage.inputDates);
		_bookingHomePage.setcheckInDate(_commonMethods.selectCheckInDate(_bookingHomePage.datePicker,checkinDatecounter));
		_bookingHomePage.setcheckOutDate(_commonMethods.selectCheckOutDate(_bookingHomePage.datePicker,_bookingHomePage.getcheckInDate(),checkoutDateCounter));
		_commonMethods.click(_bookingHomePage.guest);
		Integer adultsNumber=Integer.parseInt(_commonMethods.getMessages(_bookingHomePage.guestContainerAdults));
		if(adultsNumber<adultsNumberWanted){
			for (int i = 0; i < adultsNumberWanted-adultsNumber; i++) {
				_commonMethods.click(_bookingHomePage.adultNumberAsc);
			}
		}
		else{
			for (int i = 0; i < adultsNumber-adultsNumberWanted; i++) {
				_commonMethods.click(_bookingHomePage.adultNumberDesc);
			}
		}
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerAdults), bookingAssert.expectedAdults);
		Integer childrenNumber=Integer.parseInt(_commonMethods.getMessages(_bookingHomePage.guestContainerChildren));
		if(childrenNumber<childrenNumberWanted){
			for (int i = 0; i < childrenNumberWanted-childrenNumber; i++) {
				_commonMethods.click(_bookingHomePage.childrenNumberAsc);
			}
		}
		else{
			for (int i = 0; i < childrenNumber-childrenNumberWanted; i++) {
				_commonMethods.click(_bookingHomePage.childrenNumberDesc);
			}
		}
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerChildren),bookingAssert.expectedChildren);
		Integer roomsNumber=Integer.parseInt(_commonMethods.getMessages(_bookingHomePage.guestContainerRooms));
		if(roomsNumber<roomsNumberWanted){
			for (int i = 0; i < roomsNumberWanted-roomsNumber; i++) {
				_commonMethods.click(_bookingHomePage.roomsNumberAsc);
			}
		}
		else{
			for (int i = 0; i < roomsNumber-roomsNumberWanted; i++) {
				_commonMethods.click(_bookingHomePage.roomsNumberDesc);
			}
		}
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerRooms),bookingAssert.expectedRooms);
		_commonMethods.click(_bookingHomePage.childrenAge);
		_commonMethods.click(_bookingHomePage.childrenAge9);
		_commonMethods.click(_bookingHomePage.searchButton);
		Assert.assertEquals(myDriver.getTitle(),bookingAssert.bookingSearchPageTitle);
	}
	@Test(priority=2)
	public void testPageTwo(){
		BookingSearchPage _bookingSearchPage = bookingSearchPage();
		BookingHotelPage _bookingHotelPage = bookingHotelPage();
		commonMethods _commonMethods = commonMethods();
		waits wait = waits();
		boolean flag = true;
		String secondHotelTile="";
		String searchPage = _commonMethods.getPageContext();
		_commonMethods.click(_bookingSearchPage.filterFiveStars);
		while(wait.waitToDesappear(_bookingSearchPage.loadingString)&&flag){
			secondHotelTile = _commonMethods.getMessages(_bookingSearchPage.secondHotelTitle);
			Assert.assertNotNull(secondHotelTile);
			Assert.assertNotEquals(secondHotelTile,"");
			Assert.assertNotNull(_commonMethods.getMessages(_bookingSearchPage.secondHotelScore));
			Assert.assertNotEquals(_commonMethods.getMessages(_bookingSearchPage.secondHotelScore),"");
			Assert.assertNotNull(_commonMethods.getMessages(_bookingSearchPage.secondHotelPrice));
			Assert.assertNotEquals(_commonMethods.getMessages(_bookingSearchPage.secondHotelPrice),"");
			_commonMethods.click(_bookingSearchPage.secondHotelChooseButton);
			_commonMethods.switchPage(2);
			String hotelPage = _commonMethods.getPageContext();
			flag=false;
		}
		wait.waitToAppear(_bookingHotelPage.bookedButtonString);
		Assert.assertTrue(_commonMethods.getMessages(_bookingHotelPage.hotelTitle).contains(secondHotelTile));


	}

	@Test(priority=3)
	public void testPageThree(){
		BookingSearchPage _bookingSearchPage = bookingSearchPage();
		BookingHomePage _bookingHomePage = bookingHomePage();
		BookingHotelPage _bookingHotelPage = bookingHotelPage();
		BookingDataPage _bookingData = bookingDataPage();
		commonMethods _commonMethods = commonMethods();
		Assert.assertEquals(_commonMethods.getMessages(_bookingHotelPage.bookedInfo),bookingAssert.bookingInfo);
		Assert.assertEquals(_commonMethods.getMessages(_bookingHotelPage.bookedhotelPrice),bookingAssert.bookingHotelPrice);
//		Assert.assertTrue(_commonMethods.getMessages(_bookingHotelPage.checkInDate).contains(_commonMethods.datetoDateString(_bookingHomePage.getcheckInDate()).split("-")[0]));
//		Assert.assertTrue(_commonMethods.getMessages(_bookingHotelPage.checkInDate).contains(_commonMethods.datetoDateString(_bookingHomePage.getcheckInDate()).split("-")[2]));
//		Assert.assertTrue(_commonMethods.getMessages(_bookingHotelPage.checkOutDate).contains(_commonMethods.datetoDateString(_bookingHomePage.getcheckOutDate()).split("-")[0]));
//		Assert.assertTrue(_commonMethods.getMessages(_bookingHotelPage.checkOutDate).contains(_commonMethods.datetoDateString(_bookingHomePage.getcheckOutDate()).split("-")[2]));
		_commonMethods.click(_bookingHotelPage.rooms);
		_commonMethods.click(_bookingHotelPage.rooms1);
		_commonMethods.click(_bookingHotelPage.bookedButton);
		Assert.assertTrue(_bookingData.firstname.isDisplayed());
	}

	@Test(priority=4)
	public void testPageFour(){
		BookingDataPage _bookingData = bookingDataPage();
		commonMethods _commonMethods = commonMethods();
		_commonMethods.enterText("Alejandro",_bookingData.firstname);
		Assert.assertEquals(_bookingData.firstname.getCssValue("border-color"),bookingAssert.greenColor);
		_commonMethods.enterText("Areiza",_bookingData.lastname);
		Assert.assertEquals(_bookingData.lastname.getCssValue("border-color"),bookingAssert.greenColor);
		_commonMethods.enterText("alejandroareiza@gmail.com",_bookingData.email);
		Assert.assertEquals(_bookingData.email.getCssValue("border-color"),bookingAssert.greenColor);
		_commonMethods.enterText("alejandroareiza@gmail.com",_bookingData.email_confirm);
		Assert.assertEquals(_bookingData.email_confirm.getCssValue("border-color"),bookingAssert.greenColor);
		_commonMethods.click(_bookingData.submitButton);
		Assert.assertTrue(_bookingData.phone.isDisplayed());
		_commonMethods.enterText("123456789",_bookingData.phone);
	}

}
