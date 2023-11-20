package com.actions;

import org.openqa.selenium.support.PageFactory;

import com.locators.loginPageLocators;
import com.utility.BaseClass;

public class loginPageActions {
loginPageLocators loginpagelocators;
	
	public loginPageActions() {
		loginpagelocators = new loginPageLocators();
		PageFactory.initElements(BaseClass.getDriver(), loginpagelocators);
	}
	public void clickButton1() {
		loginpagelocators.loginButton.click();
	}
	public void clickButton2() {
		loginpagelocators.mainLogin.click();
	}
	public void setEmail(String strEmail) {
		loginpagelocators.EmailId.sendKeys(strEmail);
	}
	public void setPassword(String strPass) {
		loginpagelocators.Password.sendKeys(strPass);
	}
	public void Button() {
		loginpagelocators.Button.click();
	}
	
	public void email() {
		loginpagelocators.EmailId.sendKeys("herzutorka@gufum.com");
	}
	
	public void password() {
		loginpagelocators.Password.sendKeys("Welcome@123");
	}
	public void LoginUser(String strEmail,String strPass) {
		setEmail(strEmail);
		setPassword(strPass);
		Button();
	}
}
