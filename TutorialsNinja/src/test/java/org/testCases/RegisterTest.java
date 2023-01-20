package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.RegisterPage;
import org.pageObjects.RegisterationSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends BaseClass {
	


	@Test(groups="Sanity")
	public void validateRegister() {
		
		
	        homepage.myAccountOptionClick();
	        RegisterPage register = homepage.clickRegisterOption();
	        register.enterFirstName();
	        register.enterLastName();
	        register.enteremailId();
	        register.enterTelephone();
	        register.enterPassword();
	        register.confirmPassword();
	        register.clickCheckbox();
	        RegisterationSuccessPage registerSuccess = register.clickConfirmButton();
	        boolean actualresult = registerSuccess.verifyMsg();
	        Assert.assertTrue(actualresult);
	        soft.assertAll();
  
	}
}
