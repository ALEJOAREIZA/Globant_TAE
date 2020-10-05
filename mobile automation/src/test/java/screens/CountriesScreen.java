package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class CountriesScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     *
     * @param pDriver : AndroidDriver
     */
    public CountriesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    private static final String FIRST_LOCATOR = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Colombia\"))";

    @AndroidFindBy(uiAutomator = FIRST_LOCATOR)
    private AndroidElement optionCol;

    public PrivacidadDatos selectColombia() {
        optionCol.click();
        return new PrivacidadDatos(driver);
    }
}
