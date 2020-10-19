package com.booking.automation.tests;

import com.booking.automation.commonMethods.commonMethods;
import com.booking.automation.pages.BookingHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests extends BaseTests {

	@Test(priority=1)
	public void test1() {
		BookingHomePage _bookingHomePage = bookingHomePage();
		commonMethods _commonMethods = commonMethods();
		int  checkingdate=1;
		int  checkoutdate=2;
		int adultsNumberWanted=3;
		int childrenNumberWanted=1;
		int roomsNumberWanted=1;

		_commonMethods.click(_bookingHomePage.tabAccomodations);
		_commonMethods.enterText("Bogotá, Colombia",_bookingHomePage.inputDestination);
		_commonMethods.click(_bookingHomePage.inputDates);
		_commonMethods.selectCheckInDate(_bookingHomePage.datePicker,checkingdate);
		_commonMethods.selectCheckInDate(_bookingHomePage.datePicker,checkoutdate);
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
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerAdults),"3");
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
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerChildren),"1");
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
		Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.guestContainerRooms),"1");

		_commonMethods.click(_bookingHomePage.childrenAge);
		_commonMethods.click(_bookingHomePage.childrenAge9);
		//Assert.assertEquals(_commonMethods.getMessages(_bookingHomePage.childrenAge),"9");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		_commonMethods.click(_bookingHomePage.searchButton);


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
