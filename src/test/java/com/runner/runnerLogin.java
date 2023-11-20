package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@InvalidScenario",features="src\\test\\resources\\features\\login.feature",glue ="com.stepDefinitions",plugin= {"pretty","html:target/test-reports/cucumber.html","pretty","json:target/cucmber-reports/cucumber.json"})

public class runnerLogin {

}
