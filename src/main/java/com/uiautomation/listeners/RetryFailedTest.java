package com.uiautomation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.uiautomation.enums.ConfigProperties;
import com.uiautomation.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer{

	private int count = 0 ;
	private int limit = 1;

	
	public boolean retry(ITestResult result) {
		
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("Yes")) {
				if(count<limit) {
					count++;
					return true;
				}
			}
		
		return false;
	}

}
