package tests;

import HelpersMethods.TrivagoHelpersMethods;
import org.testng.Assert;
import Asserts.TrivagoAsserts;
import org.testng.annotations.Test;
import screens.CountriesScreen;
import screens.LandingViewScreen;
import screens.DataPrivacyScreen;

import screens.choosingDatesScreen;
import util.tests.BaseMobileTest;
import util.CustomWait;

public class TrivagoTest extends BaseMobileTest {

//	/**
//	 * Verify something.
//	 *
//	 * @author AnyOne
//	 *
//	 */
//	@Parameters({ "someParameter", "someParameter" })
//	@Test(groups = { "someGroup" })
//	public void someTest() {
//		FirstScreen nameOfMyFirstScreen = returnFirstScreen();
//		nameOfMyFirstScreen.someInstructions();
//		SecondScreen nameOfMySecondScreen = nameOfMyFirstScreen.returnSecondScreen();
//		nameOfMySecondScreen.flowInsideSecondScreen();
//	}

	@Test(priority = 1)
	public void DataPrivacyTest() {
		CountriesScreen countries = returnCountriesScreen();
		LandingViewScreen landingView = returnLandingViewScreen();
		CustomWait wait = returnCustomWait();
		DataPrivacyScreen dataPrivacy = countries.selectColombia();
		Assert.assertEquals(dataPrivacy.privacyTitle.getText(), TrivagoAsserts.privacyTitle);
		Assert.assertEquals(dataPrivacy.privacyBody,TrivagoAsserts.privacyBody);
		dataPrivacy.confirm();
		//wait.waitAndroidElementVisibility(privacidad.Title, wait.SHORT_WAIT_SECONDS);
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(landingView.searchHotelButton));
	}
	@Test(priority = 2)
	public void searchHotelTest() {
		LandingViewScreen landingView = returnLandingViewScreen();
		choosingDatesScreen choosingDates = landingView.selectCartagena();
	}



}
