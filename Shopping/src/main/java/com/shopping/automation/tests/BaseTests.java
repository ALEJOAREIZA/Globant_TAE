package com.shopping.automation.tests;

		import com.shopping.automation.commonMethods.commonMethods;
		import com.shopping.automation.pages.ProductPage;
		import com.shopping.automation.MyDriver;
		import org.testng.annotations.AfterSuite;
		import org.testng.annotations.BeforeSuite;


public class BaseTests {

	MyDriver myDriver;
	private ProductPage _productpage;
	private commonMethods _commonMethods;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new MyDriver();
		_productpage = new ProductPage(myDriver.getDriver());
		_commonMethods = new commonMethods(myDriver.getDriver());
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		myDriver.dispose();
	}
	public ProductPage productPage(){return _productpage;}
	public commonMethods commonMethods(){return _commonMethods;}



}

