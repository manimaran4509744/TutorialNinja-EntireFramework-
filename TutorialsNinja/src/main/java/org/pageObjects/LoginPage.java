
package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ActionDriver {
	@FindBy(id = "input-email")
	public WebElement username;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;
	@FindBy(xpath = "(//a[text()='Forgotten Password'])[1]")
	public WebElement forgotPassword;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement confirmMsg;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public void enterUsername(String userName1) {
		ActionDriver.type(username, userName1);
	}

	public void enterPassword(String passWord1) {
		ActionDriver.type(password, passWord1);
	}

	public ForgotPasswordPage clickForgotPassword() {
		ActionDriver.click(getDriver(), forgotPassword);
		ForgotPasswordPage forgot = new ForgotPasswordPage();
		return forgot;

	}

	public AccountPage clickLoginButton() {
		ActionDriver.click(getDriver(), loginButton);
		AccountPage account = new AccountPage();
		return account;

	}

	public boolean verifyMsg() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), confirmMsg);
		return displayed;
	}

}
