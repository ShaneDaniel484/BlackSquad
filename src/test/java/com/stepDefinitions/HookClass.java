package com.stepDefinitions;

import com.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class HookClass {
	@Before
	public static void setup() {
		BaseClass.setUpDriver();
	}
	@After
	public static void tearDown(Scenario scenario) {
		//BaseClass.tearDown();
	}
}