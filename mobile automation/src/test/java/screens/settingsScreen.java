package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.CustomWait;
import util.screens.BaseScreen;

import static io.appium.java_client.touch.offset.PointOption.point;

public class settingsScreen extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public settingsScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }
    DataPrivacySettingsScreen dataPrivacySettings = new DataPrivacySettingsScreen(driver);
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/action_settings\")")
    public AndroidElement settingsButton2;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"¡Disfruta de trivago!\"))")
    public AndroidElement settingsScreenHeader;

    public String TextView = "android.widget.TextView";
    public String View = "android.view.View";
    public String FrameLayout = "android.widget.FrameLayout";
    public String ViewGroup = "android.view.ViewGroup";



    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentSettingsManageMyDataTextView\")")
    public AndroidElement privacydataSettingsbutton;

    public void gotoSettings(){
        settingsButton2.click();
        CustomWait.waitAndroidElementVisibility(settingsScreenHeader, CustomWait.SHORT_WAIT_SECONDS);
    }


    public DataPrivacySettingsScreen gotoPrivacyDataSettings() {
        privacydataSettingsbutton.click();
        CustomWait.waitAndroidElementVisibility(dataPrivacySettings.privacydataSettings, CustomWait.SHORT_WAIT_SECONDS);
        return new DataPrivacySettingsScreen(driver);
    }

}
