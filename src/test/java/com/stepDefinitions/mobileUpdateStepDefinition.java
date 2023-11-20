package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.actions.loginPageActions;
import com.actions.mobileUpdateAction;
import com.utility.BaseClass;
import com.utility.utilityclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mobileUpdateStepDefinition {

    WebDriver driver;
    mobileUpdateAction action = new mobileUpdateAction(BaseClass.getDriver());
    loginPageActions loginActions = new loginPageActions();
    utilityclass data;
    
    @Given("USER IS on Thomascook Website")
    public void user_is_on_thomascook_website() {
    	BaseClass.openPage(null);
    	loginActions.clickButton1();
    	loginActions.clickButton2();
//    	loginActions.setEmail(data.EmailId);
//    	loginActions.setPassword(data.Password);
    	loginActions.email();
    	loginActions.password();
    	loginActions.Button();
    }

    @When("the user click on my account")
    public void the_user_click_on_my_account() {
        action.clickOnMyAccount();
    }

    @When("the user click an View  My account")
    public void the_user_click_an_view_my_account() {
        action.clickOnViewMyAccount();
    }

    @When("the user click a edit button")
    public void the_user_click_a_edit_button() {
        action.clickOnEditButton();
    }

    @When("the user changes a mobile number")
    public void the_user_changes_a_mobile_number() {
        action.changeMobileNumber();
    }

    @When("user click a save button")
    public void user_click_a_save_button() {
        action.clickOnSaveButton();
    }

    @Then("changes successfull message is displayed")
    public void changes_successfull_message_is_displayed() {
        action.getSuccessMessage();
    }
    

}

