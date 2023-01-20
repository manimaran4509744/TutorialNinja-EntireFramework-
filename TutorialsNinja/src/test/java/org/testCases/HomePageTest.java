package org.testCases;

import org.baseClass.BaseClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

	@Test(priority = 1, groups = "Smoke")
	public void validateLogo() {
		boolean actual = homepage.validateLogo();
		soft.assertTrue(actual);

	}

	@Test(priority = 2, groups = "Sanity")
	public void validateMasterImage() {
		boolean actual = homepage.validateMasterImage();
		soft.assertTrue(actual);

	}

	@Test(priority = 3, groups = "Sanity")
	public void validateFeatureImage() {
		boolean actual = homepage.validateFeatureImage();
		soft.assertTrue(actual);
		soft.assertAll();
	}

}
