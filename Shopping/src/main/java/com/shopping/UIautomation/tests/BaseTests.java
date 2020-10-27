package com.shopping.UIautomation.tests;

		import com.shopping.APIautomation.baseService.shoppingService;
		import com.shopping.UIautomation.commonMethods.commonMethods;
		import com.shopping.UIautomation.pages.ProductPage;
		import com.shopping.UIautomation.MyDriver;
		import org.testng.annotations.AfterSuite;
		import org.testng.annotations.BeforeSuite;


public class BaseTests {

	MyDriver myDriver;
	private ProductPage _productpage;
	private commonMethods _commonMethods;
	private shoppingService _shoppingService;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		_shoppingService = new shoppingService();
		_shoppingService.createProduct();
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

