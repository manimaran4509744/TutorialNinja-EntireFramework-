package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends ActionDriver {
	@FindBy(id = "input-firstname")
	public WebElement firstName;
	@FindBy(id = "input-lastname")
	public WebElement lastName;
	@FindBy(id = "input-email")
	public WebElement emailId;
	@FindBy(id = "input-telephone")
	public WebElement telephone;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(id = "input-confirm")
	public WebElement confirmPassword;
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement checkbox;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement confirmButton;

	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterFirstName() {
		ActionDriver.click(getDriver(), firstName);
//		ActionDriver.JSClick(driver, firstName);
		ActionDriver.type(firstName, prop.getProperty("firstName"));
	}

	public void enterLastName() {
		ActionDriver.click(getDriver(), lastName);
//		ActionDriver.JSClick(driver, lastName);
		ActionDriver.type(lastName, prop.getProperty("lastName"));

	}

	public void enteremailId() {
		ActionDriver.click(getDriver(), emailId);
//		ActionDriver.JSClick(driver, emailId);
		ActionDriver.type(emailId, prop.getProperty("emailId"));
	}

	public void enterTelephone() {
		ActionDriver.click(getDriver(), telephone);
//		ActionDriver.JSClick(driver, telephone);
		ActionDriver.type(telephone, prop.getProperty("telephone"));

	}

	public void enterPassword() {
		ActionDriver.click(getDriver(), password);
//		ActionDriver.JSClick(driver, password);
		ActionDriver.type(password, prop.getProperty("registerpassword"));

	}

	public void confirmPassword() {
		ActionDriver.click(getDriver(), confirmPassword);
//		ActionDriver.JSClick(driver, confirmPassword);
		ActionDriver.type(confirmPassword, prop.getProperty("confirmPassword"));

	}

	public void clickCheckbox() {
		ActionDriver.JSClick(getDriver(), checkbox);

	}

	public RegisterationSuccessPage clickConfirmButton() {
		ActionDriver.JSClick(getDriver(), confirmButton);
		RegisterationSuccessPage successpage = new RegisterationSuccessPage();
		return successpage;
	}

}
