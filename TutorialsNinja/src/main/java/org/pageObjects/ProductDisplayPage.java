package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage extends ActionDriver {

	@FindBy(id = "button-cart")
	public WebElement addToCart;
	@FindBy(xpath = "//a[text()='shopping cart']")
	public WebElement successMsg;
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	public WebElement shoppingPage;

	public ProductDisplayPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickAddToCart() {
		ActionDriver.JSClick(getDriver(), addToCart);

	}

	public boolean verifySucessMsg() {
		ActionDriver.explicitWait(getDriver(), successMsg, 10);
		boolean displayed = ActionDriver.isDisplayed(getDriver(), successMsg);
		return displayed;
	}

	public ShoppingCartPage clickShoppingCart() {
		ActionDriver.JSClick(getDriver(), shoppingPage);
		ShoppingCartPage shopping = new ShoppingCartPage();
		return shopping;

	}

}
