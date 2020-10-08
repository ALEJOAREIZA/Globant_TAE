package HelpersMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import util.CustomWait;
import util.screens.BaseScreen;
import util.tests.BaseMobileTest;

import screens.CountriesScreen;

import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class TrivagoHelpersMethods {

    protected AndroidDriver<AndroidElement> driver;


    public TrivagoHelpersMethods(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }


    public void scroll(PointOption startpoint, PointOption endpoint){
        new TouchAction(driver)
                .press(startpoint)
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(endpoint)
                .release()
                .perform();
    }
}
