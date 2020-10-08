package screens;

import HelpersMethods.TrivagoHelpersMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import util.CustomWait;
import util.screens.BaseScreen;

import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class CountriesScreen extends BaseScreen {
    CustomWait wait = new CustomWait(driver);
    TrivagoHelpersMethods helpersMethods = new TrivagoHelpersMethods(driver);

    public CountriesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Colombia\"))")
    private AndroidElement colombiaCountry;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityPlatformSelectionConfirmButton\")")
    private AndroidElement confirmButton;

    public DataPrivacyScreen selectColombia() {
        colombiaCountry.isDisplayed();
        helpersMethods.scroll(point(710,500),point(710,10));
        colombiaCountry.click();
        confirmButton.click();
        return new DataPrivacyScreen(driver);
    }




}
