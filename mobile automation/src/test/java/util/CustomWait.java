package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.screens.BaseScreen;

/**
 * Class to manage the synchronization of elements with waits.
 * 
 */
public class CustomWait  extends BaseScreen {
	// time in seconds for waits methods.
	public final long MIN_WAIT_SECONDS = 1;
	public static final long SHORT_WAIT_SECONDS = 5;
	public final long NORMAL_WAIT_SECONDS = 15;
	public final long MEDIUM_WAIT_SECONDS = 40;
	public final long LARGE_WAIT_SECONDS = 60;
	private static final int SECONDS_CONVERSION = 1000;


	public CustomWait(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}


	public static void waitAndroidElementVisibility(AndroidElement mobileElement,
                                                    long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
	}


	public void waitAndroidElementInvisibility(AndroidElement mobileElement,
			long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.invisibilityOf(mobileElement));
	}


	public void waitAndroidElementToBeClickable(AndroidDriver<AndroidElement> driver, AndroidElement mobileElement,
			long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
	}

	/**
	 * Wait of seconds method.
	 * 
	 * @param seconds
	 *            : Integer
	 */
	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * SECONDS_CONVERSION);
		} catch (InterruptedException ex) {
			Thread.currentThread()
				.interrupt();
			Logger.error(ex.getMessage(), ex);
		}
	}
}
