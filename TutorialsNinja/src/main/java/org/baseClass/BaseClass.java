package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.actionDrivers.ActionDriver;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pageObjects.HomePage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.utilities.*;

public class BaseClass {
	public static FileInputStream fis;

	public static Properties prop;
	public static HomePage homepage;
	public static SoftAssert soft;
	// public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();

	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public static void loadReport() {
		ExtentReportClass.createReport();
		Configurator.initialize(null, System.getProperty("user.dir") + "/log4j2.xml");
		prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");

		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void launch(String browser) {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());

			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		}
		getDriver().manage().window().maximize();
		ActionDriver.implicitWait(getDriver(), 10);
		ActionDriver.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		homepage = new HomePage();

	}

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launch(browser);
		soft = new SoftAssert();

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void assertthrow() {

		getDriver().quit();

	}

	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		ExtentReportClass.endReport();
	}

}
