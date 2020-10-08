package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class DestinationScreen extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public DestinationScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHotelSearchResultsExpandedDealformDestinationTextView\")")
    public AndroidElement destinationInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/fragmentHotelSearchResultsExpandedDealformCalendarTextView\")")
    public AndroidElement datesInput;

}
