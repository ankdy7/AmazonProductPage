package Resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	String filepath;
	ExtentReports extent = ExtentReporterNG.getReportObejct();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test was Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
