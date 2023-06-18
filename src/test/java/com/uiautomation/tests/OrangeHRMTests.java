package com.uiautomation.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.uiautomation.listeners.RetryFailedTest;
import com.uiautomation.pages.OrangeHRMLoginPage;
import com.uiautomation.utils.DataProviderUtils;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests(){
		
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class,retryAnalyzer = RetryFailedTest.class)
	public void loginLogoutTest(Map<String, String> data) {
		
		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("Username"))
				.enterPassword(data.get("Password"))
				.clickLogin()
				.clickWelcome()
				.clicklogout()
				.getTitle();
		
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class,retryAnalyzer = RetryFailedTest.class)
	public void newTest(Map<String, String> data) {
		
		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("Username"))
				.enterPassword(data.get("Password"))
				.clickLogin()
				.clickWelcome()
				.clicklogout()
				.getTitle();
		
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	
	
	//(dataProvider = "LoginTestDataProvider")
//	@DataProvider(name="LoginTestDataProvider",parallel = true)
//	public Object[][] getData(){
//		return new Object[][] {
//				{ "Admin", "admin123" }
//				/*
//				 * , {"Admin123","admin"}
//				 */
//		};
//		
//	}
}
