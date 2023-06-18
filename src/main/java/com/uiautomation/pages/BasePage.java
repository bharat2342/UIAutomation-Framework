package com.uiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.uiautomation.driver.DriverManager;
import com.uiautomation.enums.WaitStrategy;
import com.uiautomation.factories.ExplicitWaitFactory;
import com.uiautomation.reports.ExtentLogger;

public class BasePage {

	protected void click(By by,WaitStrategy waitstrategy,String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementname + " is clicked",true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	protected void sendkeys(By by,String value,WaitStrategy waitstrategy,String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass( value +" is entered successfully in "+elementname,true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
//	private void explicityWaitForElementToBeClickable(By by) {
//		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
//		.until(ExpectedConditions.elementToBeClickable(by));
//	}
//	 
//	private void explicityWaitForElementToBePresent(By by) {
//		new WebDriverWait(DriverManager.getDriver(), 10)
//		.until(ExpectedConditions.presenceOfElementLocated(by));
//	}
}

