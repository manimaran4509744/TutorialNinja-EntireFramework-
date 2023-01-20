package org.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass implements ITestListener {
	public static ExtentTest test;

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getName() + "is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getName() + "is Failed");
		test.log(Status.FAIL,
				MarkupHelper.createLabel("This Test case is failed" + result.getThrowable(), ExtentColor.RED));
		// test.addScreenCaptureFromPath(ScreenShotClass.takeScreenShot(result.getName()),
		// "Screenshot is added");
		test.fail("Screenshot is added", MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenShotClass.takeScreenShot(result.getName())).build());

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = ExtentReportClass.report.createTest(result.getName());

	}

}
