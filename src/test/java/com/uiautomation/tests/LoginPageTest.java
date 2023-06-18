package com.uiautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.uiautomation.driver.DriverManager;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {
		
	}


	@Test
	public void test1(){

		DriverManager.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("Automation",Keys.ENTER);

	}
}
