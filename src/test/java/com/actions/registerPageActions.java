// Import necessary packages
package com.actions;

import java.time.Duration;

// Import Selenium packages
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Import custom classes
import com.locators.registerPageLocators;
import com.utility.BaseClass;

// Class to perform actions on the Registration page
public class registerPageActions {
    // Initialize Actions, locators, WebDriverWait, and JavascriptExecutor
    Actions act = new Actions(BaseClass.getDriver());
    registerPageLocators registerLocators = null;
    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) BaseClass.getDriver();

    // Constructor to initialize locators and PageFactory
    public registerPageActions() {
        this.registerLocators = new registerPageLocators();
        PageFactory.initElements(BaseClass.getDriver(), registerLocators);
    }

    // Clicks the "Login" button
    public void clickLogin() {
        registerLocators.loginButton.click();
    }

    // Clicks the "Register User" button
    public void clickRegisterUser() {
        registerLocators.registerUser.click();
    }

    // Sets the value in the "First Name" field
    public void setFirstname(String firstname) {
        wait.until(ExpectedConditions.visibilityOf(registerLocators.firstname)).sendKeys(firstname);
    }

    // Sets the value in the "Last Name" field
    public void setLastname(String lastname) {
        registerLocators.lastname.sendKeys(lastname);
    }

    // Sets the value in the "Email" field
    public void setEmail(String email) {
        registerLocators.email.sendKeys(email);
    }

    // Sets the value in the "Mobile" field
    public void setMobile(String mobile) {
        wait.until(ExpectedConditions.visibilityOf(registerLocators.mobile)).sendKeys(mobile);
    }

    // Sets the value in the "Password" field
    public void setPassword(String password) {
        registerLocators.password.sendKeys(password);
    }

    // Sets the value in the "Confirm Password" field
    public void setCpassword(String cpassword) {
        registerLocators.cPassword.sendKeys(cpassword);
    }

    // Clicks the "Register" button using JavaScript Executor
    public void clickRegister() throws InterruptedException {
        jse.executeScript("document.getElementById('registerButton').click()");
        registerLocators.registerButton.click();
    }

    // Asserts the successful registration by checking the presence of the register Button
    public void registerAssert() {
        //act.moveToElement(registerLocators.dropDown).click().perform();
    	Boolean register = registerLocators.registerButton.isDisplayed();
    	Assert.assertTrue(register);
    	System.out.println("Successfully asserted");
    }

    // Registers a new account by providing details
    public void registerAccount(String firstname, String lastname, String email, String mobile, String password, String cpassword) {
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setMobile(mobile);
        setPassword(password);
        setCpassword(cpassword);
    }
}
