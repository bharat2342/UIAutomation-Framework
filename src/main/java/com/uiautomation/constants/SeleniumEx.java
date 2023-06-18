package com.uiautomation.constants;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEx {
 public static void main(String[] args) { 
		System.setProperty("webdriver.chrome.driver","C:\\Basic for windows\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
//	    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
//	    WebDriver driver = new ChromeDriver();
//		driver.get(baseURL);
//
//		Select drpCountry = new Select(driver.findElement(By.name("country")));
//		drpCountry.selectByVisibleText("ANTARCTICA");
//
//		//Selecting Items in a Multiple SELECT elements
//		driver.get("http://jsbin.com/osebed/2");
//		Select fruits = new Select(driver.findElement(By.id("fruits")));
//		fruits.selectByVisibleText("Banana");
//		fruits.selectByIndex(1);
//	 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 String baseURL="http://demo.guru99.com/test/newtours/register.php";
	 WebDriver driver = new ChromeDriver();
	 driver.get(baseURL);
	 driver.manage().window().maximize();
	 driver.findElement(By.id("gh")).click();
	 String mainWindow = driver.getWindowHandle();
	 
	 
	 Set<String> allwindowHandles = driver.getWindowHandles();
	 Iterator<String> uterator = allwindowHandles.iterator();
	 
	 while(uterator.hasNext()) {
		 String child=uterator.next();
		 if(!mainWindow.equalsIgnoreCase(child)) {
			 driver.switchTo().window(child);
			 
		 }
	 }
	 
	 
 }
}
