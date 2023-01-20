package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends ActionDriver {
	@FindBy(xpath = "//img[@title='HP LP3065']")
	public WebElement product;

	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ProductDisplayPage clickProduct() {
		ActionDriver.JSClick(getDriver(), product);
		ProductDisplayPage display = new ProductDisplayPage();
		return display;
	}

	public boolean verifyImage() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), product);
		return displayed;
	}

}
