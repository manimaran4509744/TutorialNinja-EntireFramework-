package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends ActionDriver {
	@FindBy(id = "input-email")
	public WebElement emailId;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButton;

	public ForgotPasswordPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterEmailId() {
		ActionDriver.type(emailId, prop.getProperty("username"));
	}

	public LoginPage clickContinue() {
		ActionDriver.JSClick(getDriver(), continueButton);
		LoginPage loginPageObject = new LoginPage();
		return loginPageObject;

	}

}
