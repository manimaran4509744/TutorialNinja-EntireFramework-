package org.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass extends ScreenShotClass {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;

	public static void createReport() {
		report = new ExtentReports();
		String location = System.getProperty("user.dir") + "\\test-output\\ExtentReport\\TutorialNinjaReport"
				+ dateFormat() + ".html";
		spark = new ExtentSparkReporter(location);
		String xmlConfigLocation = "C:\\Users\\admin\\eclipse-workspace\\TutorialsNinja\\extent-config.xml";
		try {
			spark.loadXMLConfig(xmlConfigLocation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome,FireFox,Edge");

	}

	public static void endReport() {
		report.flush();
	}

}
