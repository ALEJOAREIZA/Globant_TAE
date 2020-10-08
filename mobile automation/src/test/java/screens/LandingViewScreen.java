package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;
import util.CustomWait;

public class LandingViewScreen extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public LandingViewScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHomeExpandedDealformSearchTextView\")")
    public AndroidElement searchHotelButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHomeExpandedDealformDestinationTextView\")")
    public AndroidElement destinationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activitySearchDestinationSearchEditText\")")
    public AndroidElement destinationInput;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Ciudad - Bolívar, Colombia, Centro- y Sudamérica\"))")
    private AndroidElement cartagenaCityOption;

    public choosingDatesScreen selectCartagena(){
        destinationButton.click();
        destinationInput.sendKeys("Cartagena");
        cartagenaCityOption.click();
        return new choosingDatesScreen(driver);
    }

}
