package com.uiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiautomation.driver.DriverManager;
import com.uiautomation.enums.WaitStrategy;
import com.uiautomation.reports.ExtentLogger;
import com.uiautomation.reports.ExtentManager;
import com.uiautomation.reports.ExtentReport;

public final class OrangeHRMHomePage extends BasePage{

	private final By link_welcome = By.xpath("//li[@class='oxd-userdropdown']");
	private final By link_logout = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		click(link_welcome,WaitStrategy.PRESENCE,"Welcome link");
		
		return this;
	}

	public OrangeHRMLoginPage clicklogout() {
		
//		new WebDriverWait(DriverManager.getDriver(), 10)
//		.until(ExpectedConditions.elementToBeClickable(link_logout));//old fashioned way
	
		//wait.until(d->d.findElement(link_logout).isEnabled()); Java 8 way
		click(link_logout,WaitStrategy.CLICKABLE,"Logout button");
//		ExtentLogger.pass("logout button clicked");
		return new OrangeHRMLoginPage();
	}
}
