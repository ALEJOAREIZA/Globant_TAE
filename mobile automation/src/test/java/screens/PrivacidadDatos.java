package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class PrivacidadDatos extends BaseScreen {

    public PrivacidadDatos(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentAcceptButton\")")
    private AndroidElement AcceptButton;

    public void confirm() {
        AcceptButton.click();
    }
}
