package com.actions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.locators.flightLocators;
import com.utility.BaseClass;

public class flightActions {
	flightLocators flightlocators;
	Actions act = null;
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(10));
	public flightActions() {
		flightlocators = new flightLocators();
		this.act=new Actions(BaseClass.getDriver());
		PageFactory.initElements(BaseClass.getDriver(), flightlocators);
	}
	public void FlightButton() {
		flightlocators.FlightButton.click();
	}
	
	public void SelectOneway() {
		flightlocators.clickOneway.click();
	}
	
	public void FromLocation(String strFromlocation) throws InterruptedException {
		flightlocators.FromAirport.sendKeys(strFromlocation);
		Thread.sleep(3000);
		flightlocators.FromAirport.sendKeys(Keys.ENTER);
		
	}
	
	public void Tolocation(String strTolocation) {
		flightlocators.ToAirport.sendKeys(strTolocation);
	}
	
	public void closeAd() throws InterruptedException {
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(flightlocators.closeAd));
		BaseClass.getDriver().switchTo().frame(0);
		
		//wait.until(ExpectedConditions.visibilityOf(flightlocators.closeAd));
		act.moveToElement(flightlocators.closeAd).click().build().perform();
		
		BaseClass.getDriver().switchTo().parentFrame();
	}
	public void clickDate() {
		
		flightlocators.clickDate.click();
	}
	public void DepartureDate() {
		flightlocators.Date.click();
	}
	
	public void SearchButton() {
		flightlocators.FlightSearch.click();
	}
	
	public void searchFlight(String strFromlocation,String strTolocation) throws InterruptedException {
		FromLocation(strFromlocation);
		Tolocation(strTolocation);
		
	}
}
