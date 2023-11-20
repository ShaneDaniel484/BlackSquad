// Import necessary packages
package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
// Import Selenium packages
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Import custom classes
import com.locators.aboutPageLocators;
import com.utility.BaseClass;

// Class to perform actions on the About page
public class aboutPageActions {
    // Initialize Actions, locators, and WebDriverWait
    Actions act = new Actions(BaseClass.getDriver());
    aboutPageLocators aboutLocators = null;
    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
    // Constructor to initialize locators and PageFactory
    public aboutPageActions() {
        this.aboutLocators = new aboutPageLocators();
        PageFactory.initElements(BaseClass.getDriver(), aboutLocators);
    }

    // Clicks on the "About Thomas Cook" link after scrolling to it
    public void clickAboutThomasCook() {
    	jse.executeScript("window.scrollTo(0, 500)");
        //act.scrollToElement(aboutLocators.aboutThomasCook).perform();
        aboutLocators.aboutThomasCook.click();
    }

    // Clicks on the "About Us" link
    public void clickAboutUs() {
        aboutLocators.aboutUs.click();
    }

    // Asserts that the text on the "About Us" page matches the expected value
    public void aboutUsAssert() {
        String aboutUsAssert = aboutLocators.aboutUsAssert.getText();
        Assert.assertEquals(aboutUsAssert, "About Thomas Cook India");
        System.out.println("About us page Asserted");
    }

    // Clicks on the "Privacy Policy" link
    public void clickPrivacyPolicy() {
        act.moveToElement(aboutLocators.privacyPolicy).click().perform();
    }

    // Asserts that the text on the "Privacy Policy" page matches the expected value
    public void privacyPolicyAssert() {
        String privacyPolicyAssert = aboutLocators.privacyPolicyAssert.getText();
        Assert.assertEquals(privacyPolicyAssert, "Thomas Cook Privacy Policies");
        System.out.println("Privacy policy page Asserted");
    }

    // Clicks on the "Board of Directors" link
    public void clickBoardOfDirectors() {
        aboutLocators.boardOfDirectors.click();
    }

    // Asserts that the text on the "Board of Directors" page matches the expected value
    public void boardOfDirectorsAssert() {
        String boardOfDirectorsAssert = aboutLocators.boardOfDirectorsAssert.getText();
        Assert.assertEquals(boardOfDirectorsAssert, "Thomas Cook Board of Directors");
        System.out.println("Board of directors page Asserted");
    }
}
