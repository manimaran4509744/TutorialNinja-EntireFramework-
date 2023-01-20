package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.ProductDisplayPage;
import org.pageObjects.SearchPage;
import org.pageObjects.ShoppingCartPage;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseClass {

	@Test(groups = "Smoke")
	public void validateShoppingCart() {
		SearchPage searchPage = homepage.search();
		homepage.clickSearch();
		ProductDisplayPage productPage = searchPage.clickProduct();
		productPage.clickAddToCart();
		ShoppingCartPage shoppingCart = productPage.clickShoppingCart();
		shoppingCart.verifyProductImage();
		soft.assertAll();

	}
}
