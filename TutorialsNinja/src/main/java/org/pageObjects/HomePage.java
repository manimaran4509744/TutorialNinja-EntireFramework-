package org.pageObjects;

import org.actionDrivers.ActionDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ActionDriver {
	@FindBy(xpath = "//input[@name='search']")
	public WebElement search;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement searchButton;
	@FindBy(xpath = "//a[text()='Your Store']")
	public WebElement logo;
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountOption;
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginOption;
	@FindBy(xpath = "//a[text()='Register']")
	public WebElement RegisterOption;
	@FindBy(xpath = "(//div[@id='content']/div[@class='swiper-viewport'])[1]")
	public WebElement masterImage;
	@FindBy(id = "content")
	public WebElement featureImage;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public SearchPage search() {
		ActionDriver.type(search, prop.getProperty("product"));
		SearchPage searchPage = new SearchPage();
		return searchPage;

	}

	public void clickSearch() {
		ActionDriver.JSClick(getDriver(), searchButton);
	}

	public void myAccountOptionClick() {
		ActionDriver.JSClick(getDriver(), myAccountOption);
	}

	public LoginPage loginOptionClick() {
		ActionDriver.JSClick(getDriver(), loginOption);
		LoginPage loginPageObject = new LoginPage();
		return loginPageObject;
	}

	public boolean validateLogo() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), logo);
		return displayed;
	}

	public boolean validateMasterImage() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), masterImage);
		return displayed;
	}

	public RegisterPage clickRegisterOption() {
		ActionDriver.JSClick(getDriver(), RegisterOption);
		RegisterPage registerPage = new RegisterPage();
		return registerPage;
	}

	public boolean validateFeatureImage() {
		boolean displayed = ActionDriver.isDisplayed(getDriver(), featureImage);
		return displayed;
	}

}
