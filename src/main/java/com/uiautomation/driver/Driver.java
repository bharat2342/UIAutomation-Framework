package com.uiautomation.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.uiautomation.constants.FrameworkConstants;
import com.uiautomation.enums.ConfigProperties;
import com.uiautomation.utils.PropertyUtils;

public final class Driver {
	
	private Driver() {
		
	}
//	private static WebDriver driver ;
	
	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
//				driver = new ChromeDriver();		
				DriverManager.setDriver(new ChromeDriver());
			}		
		
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
