package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.ForgotPasswordPage;
import org.pageObjects.LoginPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseClass {

	@Test(groups = "Smoke")
	public void validateForgotPswd() {
		homepage.myAccountOptionClick();
		LoginPage loginOptionClick = homepage.loginOptionClick();
		ForgotPasswordPage forgotPage = loginOptionClick.clickForgotPassword();
		forgotPage.enterEmailId();
		LoginPage loginPage = forgotPage.clickContinue();
		boolean actual = loginPage.verifyMsg();
		soft.assertTrue(actual);
		soft.assertAll();

	}

}
