package com.actions;

// Import necessary packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// Import custom class
import com.locators.mobileUpdateLocators;

// Class to perform actions on the Mobile Update page
public class mobileUpdateAction {

    // Initialize mobileUpdateLocators for interacting with elements
    private mobileUpdateLocators locators;

    // Constructor to initialize locators using PageFactory
    public mobileUpdateAction(WebDriver driver) {
        this.locators = new mobileUpdateLocators();
        PageFactory.initElements(driver, this.locators);
    }

    // Clicks on the "My Account" dropdown
    public void clickOnMyAccount() {
        locators.Accountdropdown.click();
    }

    // Clicks on the "View My Account" option
    public void clickOnViewMyAccount() {
        locators.Viewmyaccount.click();
    }

    // Clicks on the "Edit" button to modify account details
    public void clickOnEditButton() {
        locators.Edit.click();
    }

    // Clears the existing mobile number and enters a new one
    public void changeMobileNumber() {
        locators.mobileNumber.clear();
        locators.mobileNumber.sendKeys("9876584501");
    }

    // Clicks on the "Save" button to save the changes
    public void clickOnSaveButton() {
        locators.saveButton.click();
    }

    // Retrieves the success message and asserts it
    public void getSuccessMessage() {
        String successMessage = locators.successMessege.getText();
        Assert.assertEquals(successMessage, "Changes are saved successfully.");
        System.out.println("Mobile number update asserted successfully");
    }
}
