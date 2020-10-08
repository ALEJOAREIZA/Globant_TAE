package util.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.CustomWait;

import static java.lang.String.format;

import org.openqa.selenium.support.PageFactory;
import org.pmw.tinylog.Logger;

public abstract class LandingScreen {
    protected AndroidDriver<AndroidElement> driver;
    private static final int PERCENT = 100;

    public LandingScreen(AndroidDriver<AndroidElement> pDriver) {
        this.driver = pDriver;
        initElements();
    }
    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
