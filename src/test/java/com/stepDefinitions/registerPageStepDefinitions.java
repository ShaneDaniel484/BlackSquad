package com.stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.registerPageActions;
import com.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerPageStepDefinitions {
	
	
	registerPageActions registerActions = new registerPageActions();
	
	@Given("user is on thomascook homepage")
	public void user_is_on_thomascook_homepage() {
		BaseClass.openPage("https:www.thomascook.in");
	    
	}

	@When("user clicks on loginbutton")
	public void user_clicks_on_loginbutton() {
		registerActions.clickLogin();
	}

	@When("clicks on register")
	public void clicks_on_register() {
	    registerActions.clickRegisterUser();
	}

	@When("user fills in their details")
	
	
	public void user_fills_in_their_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> signUpForm = dataTable.asMaps(String.class,String.class);
	    for(Map<String,String> data : signUpForm) {
	    	String firstname = data.get("firstname");
	    	String lastname = data.get("lastname");
	    	String email = data.get("email");
	    	String mobile = data.get("mobile");
	    	String password = data.get("password");
	    	String cpassword = data.get("cpassword");
	    	registerActions.registerAccount(firstname, lastname, email,mobile, password, cpassword);
	    }
	}

	@When("user clicks register button")
	public void user_clicks_register_button() throws InterruptedException {
	    registerActions.clickRegister();
	}

	@Then("user is navigated to homepage with user logged in")
	public void user_is_navigated_to_homepage_with_user_logged_in() {
	    
		registerActions.registerAssert();
	}


}