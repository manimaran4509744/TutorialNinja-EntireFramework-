package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends ActionDriver {

	@FindBy(id = "account-account")
	public WebElement accountImage;

	public AccountPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public boolean verifyImage() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), accountImage);
		return displayed;
	}

}
