package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.CountriesScreen;
import screens.FirstScreen;
import screens.PrivacidadDatos;
import screens.SecondScreen;
import util.tests.BaseMobileTest;

public class SomeTest extends BaseMobileTest {

//	/**
//	 * Verify something.
//	 *
//	 * @author AnyOne
//	 *
//	 */
//	@Parameters({ "someParameter", "someParameter" })
//	@Test(groups = { "someGroup" })
//	public void someTest() {
//		FirstScreen nameOfMyFirstScreen = returnFirstScreen();
//		nameOfMyFirstScreen.someInstructions();
//		SecondScreen nameOfMySecondScreen = nameOfMyFirstScreen.returnSecondScreen();
//		nameOfMySecondScreen.flowInsideSecondScreen();
//	}

	@Test(groups = { "someGroup" })
	public void firstTest() {
		CountriesScreen countries = returnCountriesScreen();
		PrivacidadDatos privacidad = countries.selectColombia();
		privacidad.confirm();
	}

}
