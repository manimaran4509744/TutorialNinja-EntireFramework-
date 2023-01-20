package org.testCases;

import org.baseClass.BaseClass;
import org.pageObjects.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {

	@Test(groups = "Regression")
	public void validateSearchFunction() {
		SearchPage searchPage = homepage.search();
		homepage.clickSearch();
		boolean actual = searchPage.verifyImage();
		soft.assertTrue(actual);
		soft.assertAll();

	}

}
