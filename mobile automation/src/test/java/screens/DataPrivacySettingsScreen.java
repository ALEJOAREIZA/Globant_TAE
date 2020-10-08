package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import util.CustomWait;
import util.screens.BaseScreen;

public class DataPrivacySettingsScreen extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public DataPrivacySettingsScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerToolbar\").childSelector(new UiSelector().className(\"android.widget.TextView\").text(\"Configurar privacidad de datos\"))")
    public AndroidElement privacydataSettings;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerTitleTextView\")")
    public AndroidElement privacydataSettingsbody;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerAppsFlyerTextView\")")
    public AndroidElement appsFlyer;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFirebaseTextView\")")
    public AndroidElement GTM;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFacebookTextView\")")
    public AndroidElement Facebook;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerLearnMoreTextView\")")
    public AndroidElement footer;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerSaveButton\")")
    public AndroidElement privacyDtasaveButton;

    public String CheckBox = "android.widget.CheckBox";

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerAppsFlyerCheckbox\")")
    public AndroidElement appsFlyercheckBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFirebaseCheckbox\")")
    public AndroidElement GTMcheckBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDataManagerFacebookCheckbox\")")
    public AndroidElement FacebookcheckBox;

    public void checkboxCombinations(){
        ///111
        if(appsFlyercheckBox.getAttribute("checked").equals("false")){
            appsFlyercheckBox.click();
        }
        if(GTMcheckBox.getAttribute("checked").equals("false")){
            GTMcheckBox.click();
        }
        if(FacebookcheckBox.getAttribute("checked").equals("false")){
            FacebookcheckBox.click();
        }
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("true"))&&(GTMcheckBox.getAttribute("checked").equals("true"))&&(FacebookcheckBox.getAttribute("checked").equals("true")));

        ///000
        appsFlyercheckBox.click();
        GTMcheckBox.click();
        FacebookcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("false"))&&(GTMcheckBox.getAttribute("checked").equals("false"))&&(FacebookcheckBox.getAttribute("checked").equals("false")));

        ///100
        appsFlyercheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("true"))&&(GTMcheckBox.getAttribute("checked").equals("false"))&&(FacebookcheckBox.getAttribute("checked").equals("false")));

        ///010
        appsFlyercheckBox.click();
        GTMcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("false"))&&(GTMcheckBox.getAttribute("checked").equals("true"))&&(FacebookcheckBox.getAttribute("checked").equals("false")));

        ///001
        GTMcheckBox.click();
        FacebookcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("false"))&&(GTMcheckBox.getAttribute("checked").equals("false"))&&(FacebookcheckBox.getAttribute("checked").equals("true")));

        ///011
        GTMcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("false"))&&(GTMcheckBox.getAttribute("checked").equals("true"))&&(FacebookcheckBox.getAttribute("checked").equals("true")));

        ///101
        appsFlyercheckBox.click();
        GTMcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("true"))&&(GTMcheckBox.getAttribute("checked").equals("false"))&&(FacebookcheckBox.getAttribute("checked").equals("true")));

        ///110
        GTMcheckBox.click();
        FacebookcheckBox.click();
        Assert.assertTrue((appsFlyercheckBox.getAttribute("checked").equals("true"))&&(GTMcheckBox.getAttribute("checked").equals("true"))&&(FacebookcheckBox.getAttribute("checked").equals("false")));


    }




}
