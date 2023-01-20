package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends ActionDriver {
	@FindBy(xpath = "//div[@class='table-responsive']")
	public WebElement productImage;
	@FindBy(xpath = "//a[text()='Checkout']")
	public WebElement checkout;

	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public CheckOutPage clickCheckout() {
		ActionDriver.JSClick(getDriver(), checkout);
		CheckOutPage checkoutPage = new CheckOutPage();
		return checkoutPage;
	}

	public void verifyProductImage() {
		ActionDriver.isDisplayed(getDriver(), productImage);
	}

}
