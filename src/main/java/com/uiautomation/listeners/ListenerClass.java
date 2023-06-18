package com.uiautomation.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.uiautomation.reports.ExtentLogger;
import com.uiautomation.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener{

	public void onStart(ISuite suite) {
	
			ExtentReport.initReports();
		
	}

	public void onFinish(ISuite suite) {
		
			ExtentReport.flushReports();

		
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		
			ExtentLogger.fail(result.getMethod().getMethodName() +" is failed",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
		
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() +"is skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
