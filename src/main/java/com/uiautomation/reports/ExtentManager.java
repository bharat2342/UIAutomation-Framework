package com.uiautomation.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
		
	}
	
private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();
	//Default --> It can be accessed only within package --> Private packages
	static ExtentTest getExtentTest() {
		return extTest.get();
	}
	
	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	static void unload() {
		extTest.remove();
	}

	
}
