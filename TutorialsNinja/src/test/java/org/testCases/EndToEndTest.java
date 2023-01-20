package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.CheckOutPage;
import org.pageObjects.OrderSuccessPage;
import org.pageObjects.ProductDisplayPage;
import org.pageObjects.SearchPage;
import org.pageObjects.ShoppingCartPage;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

	@Test(groups = { "Regression", "Sanity" })
	public void validateEndToEnd() {
		SearchPage searchPage = homepage.search();
		homepage.clickSearch();
		ProductDisplayPage productPage = searchPage.clickProduct();
		productPage.clickAddToCart();
		ShoppingCartPage shoppingCart = productPage.clickShoppingCart();
		CheckOutPage checkoutPage = shoppingCart.clickCheckout();
		OrderSuccessPage orderSuccess = checkoutPage.clickBilling();
		boolean actual = orderSuccess.verifySuccesfulMsg();
		soft.assertTrue(actual);
		soft.assertAll();

	}

}
