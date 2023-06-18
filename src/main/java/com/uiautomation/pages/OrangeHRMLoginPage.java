package com.uiautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.uiautomation.driver.DriverManager;
import com.uiautomation.enums.WaitStrategy;

/**
 * @author vbollibisai
 *
 */
public final class OrangeHRMLoginPage extends BasePage{

	/*
	 * id
	 * name
	 * classname
	 * linktext
	 * partiallinktext
	 * css or xpath
	 */
	
	
	private final By textbox_username = By.name("username");
	private final By textbox_password = By.xpath("//input[@type='password' and @name ='password']");
	private final By button_login = By.xpath("//button[@type='submit']");
	
	
	
	public OrangeHRMLoginPage enterUserName(String username) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sendkeys(textbox_username,username,WaitStrategy.PRESENCE,"Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendkeys(textbox_password,password,WaitStrategy.PRESENCE,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(button_login,WaitStrategy.CLICKABLE,"Login Button");
		return new OrangeHRMHomePage();
	}
	
	
	
	public String getTitle() {
		return getPageTitle();
	}
}
