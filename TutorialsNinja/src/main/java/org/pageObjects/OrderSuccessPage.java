package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage extends ActionDriver {
	@FindBy(xpath = "//h1[text()='Your order has been placed!']")
	public WebElement orderSuccessful;

	public OrderSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifySuccesfulMsg() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), orderSuccessful);
		return displayed;
	}

}
