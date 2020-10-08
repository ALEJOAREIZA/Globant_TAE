package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class DataPrivacyScreen extends BaseScreen {

    public DataPrivacyScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentAcceptButton\")")
    private AndroidElement AcceptButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentTitleTextView\")")
    public AndroidElement privacyTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentBody1TextView\")")
    public AndroidElement privacyBody1;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentBody2TextView\")")
    public AndroidElement privacyBody2;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityCookieConsentContentBody3TextView\")")
    public AndroidElement privacyBody3;

    public String privacyBody = privacyBody1.getText()+privacyBody2.getText()+privacyBody3.getText();
    public LandingViewScreen confirm() {
        AcceptButton.click();
        return new LandingViewScreen(driver);
    }

}
