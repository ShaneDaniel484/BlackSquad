package com.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	private static BaseClass baseclass;
	private static WebDriver driver;
	public final static int TIMEOUT =10;
	
	public BaseClass(){
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
	}
	public static void openPage(String url) {
		driver.get("https://www.thomascook.in/");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver() {
		if (baseclass==null) {
			
			baseclass = new BaseClass();
		}
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	 baseclass =null;
	}
}