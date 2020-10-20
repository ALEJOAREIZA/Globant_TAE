package com.booking.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class BookingHomePage extends BasePage{

	public BookingHomePage(WebDriver pDriver) {
		super(pDriver);
	}

	private Date checkInDate;
	private Date checkOutDate;


	public Date getcheckInDate() {
		return checkInDate;
	}
	public void setcheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getcheckOutDate() {
		return checkOutDate;
	}
	public void setcheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@FindBy(css="#cross-product-bar .cross-product-bar__wrapper [data-ga-track*=\"acco\"]")
	public WebElement tabAccomodations;
	@FindBy(css="#cross-product-bar .cross-product-bar__wrapper [data-ga-track*=\"flig\"]")
	public WebElement tabFlights;
	@FindBy(css="#cross-product-bar .cross-product-bar__wrapper [data-ga-track*=\"cars\"]")
	public WebElement tabCars;
	@FindBy(css="#cross-product-bar .cross-product-bar__wrapper [data-ga-track*=\"attra\"]")
	public WebElement tabAttractions;
	@FindBy(css="#cross-product-bar .cross-product-bar__wrapper [data-ga-track*=\"taxis\"]")
	public WebElement tabTaxis;
	@FindBy(id="ss")
	public WebElement inputDestination;
	@FindBy(css="[class=xp__dates-inner]")
	public WebElement inputDates;
	@FindBy(css="[class=\"bui-calendar\"]")
	public WebElement datePicker;
	@FindBy(id="xp__guests__toggle")
	public WebElement guest;
	@FindBy(id="xp__guests__inputs-container")
	public WebElement guestContainer;
	@FindBy(css="[class=\"sb-group__field sb-group__field-adults\"] [class=\"bui-stepper__display\"]")
	public WebElement guestContainerAdults;
	@FindBy(css="[aria-label=\"Aumenta el número de Adultos\"]")
	public WebElement adultNumberAsc;
	@FindBy(css="[aria-label=\"Reduce el número de Adultos\"]")
	public WebElement adultNumberDesc;
	@FindBy(css="[class=\"sb-group__field sb-group-children \"] [class=\"bui-stepper__display\"]")
	public WebElement guestContainerChildren;
	@FindBy(css="[aria-label=\"Aumenta el número de Niños\"]")
	public WebElement childrenNumberAsc;
	@FindBy(css="[aria-label=\"Reduce el número de Niños\"]")
	public WebElement childrenNumberDesc;
	@FindBy(css="[class=\"sb-group__field sb-group__field-rooms\"] [class=\"bui-stepper__display\"]")
	public WebElement guestContainerRooms;
	@FindBy(css="[aria-label=\"Aumenta el número de Habitaciones\"]")
	public WebElement roomsNumberAsc;
	@FindBy(css="[aria-label=\"Reduce el número de Habitaciones\"]")
	public WebElement roomsNumberDesc;
	@FindBy(name="age")
	public WebElement childrenAge;
	@FindBy(css="[name=\"age\"] option:nth-child(11)")
	public WebElement childrenAge9;
	@FindBy(css="[class=\"xp__button\"] [type=\"submit\"]")
	public WebElement searchButton;

	@FindBy(css="[class=\"bui-calendar__month\"]")
	public WebElement datePickerMonth;
	@FindBy(css="[data-bui-ref=\"calendar-next\"]")
	public WebElement nextCalendarPage;


}
