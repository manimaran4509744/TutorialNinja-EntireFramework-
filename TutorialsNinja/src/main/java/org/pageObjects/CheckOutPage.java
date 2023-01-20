package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends ActionDriver {
	@FindBy(xpath = "//a[@class='accordion-toggle']")
	public WebElement billingDetails;

	@FindBy(id = "input-email")
	public WebElement username;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "(//input[@name='payment_address'])[1]")
	public WebElement selectbillingDetails;

	@FindBy(id = "button-payment-address")
	public WebElement continueBilling;

	@FindBy(xpath = "(//a[@class='accordion-toggle collapsed'])[1]")
	public WebElement delieveryDetails;
	@FindBy(xpath = "(//select[@name='address_id'])[2]")
	public WebElement clickdelieveryDetailsButton;

	@FindBy(id = "button-shipping-address")
	public WebElement ContinueDelievery;

	@FindBy(xpath = "//h4[text()='Step 4: Delivery Method']")
	public WebElement deliveryMethod;

	@FindBy(id = "button-shipping-method")
	public WebElement continueDeliveryMethod;

	@FindBy(xpath = "//input[@name='agree']")
	public WebElement ClickPaymentMethodCheckBox;

	@FindBy(id = "button-payment-method")
	public WebElement continuePaymentMethod;

	@FindBy(id = "button-confirm")
	public WebElement clickConfirmOrder;

	public CheckOutPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderSuccessPage clickBilling() {
		ActionDriver.JSClick(getDriver(), billingDetails);
		ActionDriver.type(username, prop.getProperty("username"));
		ActionDriver.type(password, prop.getProperty("password"));
		ActionDriver.JSClick(getDriver(), loginButton);
		ActionDriver.JSClick(getDriver(), continueBilling);
		ActionDriver.JSClick(getDriver(), delieveryDetails);
		ActionDriver.selectByVisibleText(
				"manimaran kumar, Beemanthoppu Bus Stop, Eraiyur, Tamil Nadu, Kanchipuram, Anglesey, United Kingdom",
				clickdelieveryDetailsButton);
		ActionDriver.JSClick(getDriver(), ContinueDelievery);
		ActionDriver.JSClick(getDriver(), deliveryMethod);
		ActionDriver.JSClick(getDriver(), continueDeliveryMethod);
		ActionDriver.JSClick(getDriver(), ClickPaymentMethodCheckBox);
		ActionDriver.JSClick(getDriver(), continuePaymentMethod);
		ActionDriver.click(getDriver(), clickConfirmOrder);
		OrderSuccessPage orderSuccess = new OrderSuccessPage();
		return orderSuccess;
	}
}
