package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.AccountPage;
import org.pageObjects.LoginPage;
import org.testng.annotations.Test;
import org.utilities.DataProviderClass;

public class loginTest extends BaseClass {

	@Test(dataProvider = "credentials", dataProviderClass = DataProviderClass.class, groups = { "Smoke", "Sanity",
			"Regression" })

	public void validateLogin(String userName1, String passWord1) {

		homepage.myAccountOptionClick();
		LoginPage loginOptionClick = homepage.loginOptionClick();
		loginOptionClick.enterUsername(userName1);
		loginOptionClick.enterPassword(passWord1);
		AccountPage accountPage = loginOptionClick.clickLoginButton();
		boolean actual = accountPage.verifyImage();
		soft.assertTrue(actual);
		soft.assertAll();
	}
}
