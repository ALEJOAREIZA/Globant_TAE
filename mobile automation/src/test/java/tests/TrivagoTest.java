package tests;

import HelpersMethods.TrivagoHelpersMethods;
import org.testng.Assert;
import Asserts.TrivagoAsserts;
import org.testng.annotations.Test;
import screens.*;

import util.tests.BaseMobileTest;
import util.CustomWait;

public class TrivagoTest extends BaseMobileTest {


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
	public void searchDestinationTest() {
		LandingViewScreen landingView = returnLandingViewScreen();
		choosingDatesScreen choosingDates = landingView.selectCartagena();
		Assert.assertTrue((TrivagoHelpersMethods.isPresent(choosingDates.choosingDatesTitle)));
		Assert.assertTrue((TrivagoHelpersMethods.isEnabled(choosingDates.confirmDatesButton)));
		DestinationScreen destination =  choosingDates.selectNovemberDates();
		Assert.assertEquals(destination.destinationInput.getText(),TrivagoAsserts.Cartagena);
		Assert.assertEquals(destination.datesInput.getText(),TrivagoAsserts.selectedDates);
	}

	@Test(priority = 3)
	public void landingViewTest() {
		LandingViewScreen landingView = returnLandingViewScreen();
		landingView.gotoHome();
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(landingView.homeButton));
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(landingView.exploreButton));
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(landingView.favouritesButton));
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(landingView.settingsButton));
	}

	@Test(priority = 4)
	public void settingsPrivacyTest() {
		settingsScreen settings = returnsettingsScreen();
		settings.gotoSettings();
		Assert.assertEquals(TrivagoHelpersMethods.numberOfElementsByclassName(settings.TextView),14);
		Assert.assertEquals(TrivagoHelpersMethods.numberOfElementsByclassName(settings.View),3);
		Assert.assertEquals(TrivagoHelpersMethods.numberOfElementsByclassName(settings.ViewGroup),8);
		Assert.assertEquals(TrivagoHelpersMethods.numberOfElementsByclassName(settings.FrameLayout),12);
		DataPrivacySettingsScreen dataprivacysettings = settings.gotoPrivacyDataSettings();
		Assert.assertEquals(dataprivacysettings.privacydataSettingsbody.getText(),TrivagoAsserts.privacyDatasettingsBody);
		Assert.assertEquals(dataprivacysettings.appsFlyer.getText(),TrivagoAsserts.privacyDatasettingsappsFlyer);
		Assert.assertEquals(dataprivacysettings.GTM.getText(),TrivagoAsserts.privacyDatasettingsGTM);
		Assert.assertEquals(dataprivacysettings.Facebook.getText(),TrivagoAsserts.privacyDatasettingsFacebook);
		Assert.assertEquals(dataprivacysettings.footer.getText(),TrivagoAsserts.privacyDatasettingsfooter);
		Assert.assertTrue(TrivagoHelpersMethods.isPresent(dataprivacysettings.privacyDtasaveButton));
		Assert.assertTrue(TrivagoHelpersMethods.isEnabled(dataprivacysettings.privacyDtasaveButton));
		Assert.assertEquals(TrivagoHelpersMethods.numberOfElementsByclassName(dataprivacysettings.CheckBox),3);
		dataprivacysettings.checkboxCombinations();
		dataprivacysettings.checkboxCombinationsnoSave();
		dataprivacysettings.checkboxCombinationsSave();

	}



}
