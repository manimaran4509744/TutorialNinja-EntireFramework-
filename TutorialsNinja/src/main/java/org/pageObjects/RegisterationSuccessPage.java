package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterationSuccessPage extends ActionDriver {

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement successPage;

	public RegisterationSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyMsg() {
		boolean actual = ActionDriver.isDisplayed(getDriver(), successPage);
		return actual;
	}

}
