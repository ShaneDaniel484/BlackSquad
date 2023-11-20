package com.actions;

// Import necessary packages
import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.locators.cruisePageLocators;
import com.utility.BaseClass;

// Class to perform actions on the Cruise page
public class cruisepageactions {
    // Initialize locators, WebDriverWait, and JavascriptExecutor
    cruisePageLocators cruisepagelocators;
    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();

    // Constructor to initialize locators and PageFactory
    public cruisepageactions() {
        this.cruisepagelocators = new cruisePageLocators();
        PageFactory.initElements(BaseClass.getDriver(), cruisepagelocators);
    }

    // Clicks the "Cruise" button and switches to the new window
    public void clickButton() throws InterruptedException {
        Thread.sleep(5000);
        cruisepagelocators.cruiseButton.click();
        String parentWindow = BaseClass.getDriver().getWindowHandle();
        Set<String> allWindows = BaseClass.getDriver().getWindowHandles();
        for (String id : allWindows) {
            BaseClass.getDriver().switchTo().window(id);
        }
    }

    // Selects the departure city from the dropdown
    public void setSelectDepartureCity() {
        cruisepagelocators.SelectDepartureCity.click();
        Select s = new Select(cruisepagelocators.SelectDepartureCity);
        s.selectByVisibleText(" Australia");
    }

    // Selects the sail month from the dropdown
    public void selectSailMonths() {
        cruisepagelocators.SailMonths.click();
        Select s = new Select(cruisepagelocators.SailMonths);
        s.selectByVisibleText("Jan-2024");
    }

    // Selects the cruise duration from the dropdown
    public void selectSelectNights() {
        cruisepagelocators.SelectNights.click();
        Select s = new Select(cruisepagelocators.SelectNights);
        s.selectByVisibleText("1 To 3 night(s)");
    }

    // Selects the cruise line from the dropdown
    public void selectSelectCruiseLine() {
        cruisepagelocators.SelectCruiseLine.click();
        Select s = new Select(cruisepagelocators.SelectCruiseLine);
        s.selectByVisibleText("Cordelia Cruises");
    }

    // Clicks the "Search" button
    public void searchButton() {
        cruisepagelocators.Search.click();
    }

    // Clicks the "Modify Search" button
    public void ModifySearchButton() {
        cruisepagelocators.ModifySearch.click();
    }

    // Waits for search results and asserts the expected result
    public void searchResults() {
        wait.until(ExpectedConditions.visibilityOf(cruisepagelocators.searchResults));
        String searchResult = cruisepagelocators.searchResults.getText();
        Assert.assertEquals(searchResult, "2 Nights | Cruise Weekender");
        System.out.println("search results asserted successfully");
    }

    // Modifies the search criteria and applies the changes
    public void modifySearch() {
        cruisepagelocators.SelectDepartureCity.click();
        Select s = new Select(cruisepagelocators.SelectDepartureCity);
        s.selectByVisibleText(" Australia");
        cruisepagelocators.modifyDate.click();
        Select s1 = new Select(cruisepagelocators.modifyDate);
        s1.selectByVisibleText(" Jan-2025");
        cruisepagelocators.applyModifySearch.click();
    }

    // Asserts the modified search results
    public void modifySearchResluts() {
        String modifySearchResults = cruisepagelocators.modifySearchResults.getText();
        Assert.assertEquals(modifySearchResults, "15 Nights | Australia");
        System.out.println("modified search results asserted successfully");
    }
}
