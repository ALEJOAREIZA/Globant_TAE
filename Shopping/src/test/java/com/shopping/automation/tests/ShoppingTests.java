package com.shopping.automation.tests;

import com.shopping.automation.MyDriver;
import com.shopping.automation.asserts.shoppingAssert;
import com.shopping.automation.commonMethods.commonMethods;
import com.shopping.automation.pages.ProductPage;
import org.omg.CORBA._PolicyStub;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTests {


	@Test(priority=1)
	public void testOne() {
		ProductPage _productPage = productPage();
		commonMethods _commonMethods = commonMethods();
		Assert.assertEquals(myDriver.getTitle(), shoppingAssert.pageTitle);
		Assert.assertTrue(_commonMethods.waitandfind(_productPage.productTitle).isDisplayed());
		Assert.assertEquals(_commonMethods.getMessages(_productPage.productTitle),shoppingAssert.productTitle);
		Assert.assertTrue(_commonMethods.waitandfind(_productPage.productPrice).isDisplayed());
		Assert.assertEquals(_commonMethods.getMessages(_productPage.productPrice),shoppingAssert.productPrice);
	}
	@Test(priority=2)
	public void testTwo() {
		ProductPage _productPage = productPage();
		commonMethods _commonMethods = commonMethods();
		_commonMethods.enterText("7",_productPage.productQuantity);
		_commonMethods.click(_productPage.addtocartButton);
		Assert.assertTrue(_commonMethods.waitandfind(_productPage.addedtocartMessage).isDisplayed());
		Assert.assertEquals(_commonMethods.getMessages(_productPage.addedtocartMessage),shoppingAssert.addedMessage);
		_commonMethods.click(_productPage.gotoCart);
		Assert.assertEquals(myDriver.getTitle(), shoppingAssert.gotocartTitle);
	}

	@Test(priority=3)
	public void testThree() {
		ProductPage _productPage = productPage();
		commonMethods _commonMethods = commonMethods();
		_commonMethods.click(_productPage.cartIcon);
		Assert.assertTrue(_commonMethods.waitandfind(_productPage.productNameList).isDisplayed());
		Assert.assertEquals(_commonMethods.getMessages(_productPage.productNameList),shoppingAssert.productTitle);
		Assert.assertEquals(_commonMethods.getMessages(_productPage.producPriceList),shoppingAssert.productPrice);
		Assert.assertEquals(_productPage.productQuantityList.getAttribute("value"),shoppingAssert.productQuantity);
	}

}
