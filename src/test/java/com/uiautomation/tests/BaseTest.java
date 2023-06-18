package com.uiautomation.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.uiautomation.driver.Driver;
import com.uiautomation.reports.ExtentReport;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
//	WebDriver driver;
			
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data){
		Map<String,String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("Browser"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
