// Import necessary packages
package com.actions;

import java.time.Duration;

// Import Selenium packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Import custom classes
import com.locators.tourPackageLocators;
import com.utility.BaseClass;

// Class to perform actions on the Tour Package page
public class tourPackageActions {
    // Initialize WebDriver, Actions, locators, and WebDriverWait
    WebDriver driver;
    Actions act = new Actions(BaseClass.getDriver());
    tourPackageLocators tourLocators = null;
    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));

    // Constructor to initialize locators and PageFactory
    public tourPackageActions() {
        this.tourLocators = new tourPackageLocators();
        PageFactory.initElements(BaseClass.getDriver(), tourLocators);
    }

    // Selects a holiday place in the tour package page
    public void selectPlace(String place) {
        tourLocators.holidayPlace.sendKeys(place);
    }

    // Selects a budget option in the tour package page
    public void selectBudget() {
        tourLocators.budgetSelect.click();
        tourLocators.budget.click();
    }

    // Selects a month option in the tour package page
    public void selectMonth() {
        tourLocators.monthSelect.click();
        tourLocators.month.click();
    }

    // Clicks the search button in the tour package page
    public void clickSearch() {
        tourLocators.searchButton.click();
    }

    // Sorts the tour packages by duration (High to Low) in the tour package page
    public void sort() {
        Select select = new Select(tourLocators.sortButton);
        select.selectByVisibleText("Duration - High to Low");
    }

    // Asserts that the sorted package is "Paradise In Perth"
    public void sortAssert() {
        String assertText = tourLocators.sortassert.getText();
        Assert.assertEquals(assertText, "Paradise In Perth");
        // System.out.println("Asserted successfully");
    }
}
