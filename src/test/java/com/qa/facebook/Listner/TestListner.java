package com.qa.facebook.Listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.facebook.qa.base.TestBase;
import com.facebook.qa.util.TestUtil;

public class TestListner extends TestBase implements ITestListener {
	
	TestUtil util = new TestUtil();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ ":On test start");
		extent.attachReporter(spark);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ ":On test success");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.pass("successfully executed");
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ ":On test failure");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.fail("test got failed");
		try {
			String name = result.getMethod().getMethodName();
			util.failedTest(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		//test.addScreenCaptureFromBase64String(null);
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ ":On test skipped");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.fail("test got skipped");
		extent.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
