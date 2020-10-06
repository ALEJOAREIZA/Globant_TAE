package screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import util.screens.BaseScreen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CountriesScreen extends BaseScreen {

    public CountriesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"esko\"))")
    private AndroidElement optioncesko;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Colombia\"))")
    private AndroidElement optionColombia;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityPlatformSelectionConfirmButton\")")
    private AndroidElement Confirm;

    public PrivacidadDatos selectColombia() {
        optioncesko.isDisplayed();
        optionColombia.click();
        Confirm.click();
        return new PrivacidadDatos(driver);
    }


}
