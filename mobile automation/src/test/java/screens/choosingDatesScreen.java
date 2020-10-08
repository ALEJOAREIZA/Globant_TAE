package screens;

import HelpersMethods.TrivagoHelpersMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Coordinates;
import util.screens.BaseScreen;

import java.awt.*;
import java.text.MessageFormat;

import static io.appium.java_client.touch.offset.PointOption.point;

public class choosingDatesScreen extends BaseScreen {

    TrivagoHelpersMethods helpersMethods = new TrivagoHelpersMethods(driver);
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public choosingDatesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Seleccionar fechas\"))")
    public AndroidElement choosingDatesTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.trivago:id/activityDatesSelectionCalendarApplyTextView\")")
    public AndroidElement confirmDatesButton;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"noviembre\"))")
    public AndroidElement novemberCalendar;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").text(\"1\"))")
    public AndroidElement november1;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").text(\"5\"))")
    public AndroidElement november5;


    public DestinationScreen selectNovemberDates() {
        novemberCalendar.isDisplayed();
        Point novemberpoint =  novemberCalendar.getCenter();
        if (novemberpoint.y>500){
            helpersMethods.scroll(point(500,500),point(500,10));
        }
        november1.click();
        november5.click();
        confirmDatesButton.isEnabled();
        confirmDatesButton.click();
        return new DestinationScreen(driver);
    }


}
