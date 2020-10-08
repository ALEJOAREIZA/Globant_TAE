package util.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeSuite;
import screens.CountriesScreen;
import screens.DestinationScreen;
import screens.LandingViewScreen;
import screens.DataPrivacyScreen;
import util.ConfigCapabilities;
import util.CustomWait;

/**
 * Base class for Test classes.
 * 
 */
public abstract class BaseMobileTest {

	private AndroidDriver<AndroidElement> driver;


	/**
	 * SetUp before to run suite of test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@BeforeSuite(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException exception) {
			Logger.error(exception.getMessage(), exception);
		}
	}

	/**
	 * Close the application after completing the test.
	 * 
	 */
	@AfterSuite(alwaysRun = true)
	public void mobileApplicationEnd() {
		 driver.quit();
	}



	protected CountriesScreen returnCountriesScreen() {
		return new CountriesScreen(driver);
	}
	protected DataPrivacyScreen returnDataPrivacy() {
		return new DataPrivacyScreen(driver);
	}
	protected LandingViewScreen returnLandingViewScreen() {
		return new LandingViewScreen(driver);
	}
	protected CustomWait returnCustomWait() {
		return new CustomWait(driver);
	}
	protected DestinationScreen returnDestinationScreen() {
		return new DestinationScreen(driver);
	}


}
