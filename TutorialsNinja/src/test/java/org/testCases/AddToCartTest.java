package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.ProductDisplayPage;
import org.pageObjects.SearchPage;
import org.testng.annotations.Test;
import org.utilities.LoggerClass;

public class AddToCartTest extends BaseClass {

	@Test(groups = { "Smoke", "Sanity" })
	public void validateSuccessMsg() {
		// This is static method moreover Loggerclass is from another package so firstly
		// we've to import that pkg,class here and call that class variables with its
		// classname.methodname();
		LoggerClass.startTestCase("validateSuccessMsg");
		SearchPage searchPage = homepage.search();
		homepage.clickSearch();
		ProductDisplayPage productPage = searchPage.clickProduct();
		productPage.clickAddToCart();
		boolean actual = productPage.verifySucessMsg();
		soft.assertTrue(actual);
		LoggerClass.endTestCase("validateSuccessMsg");
		soft.assertAll();
	}

}
