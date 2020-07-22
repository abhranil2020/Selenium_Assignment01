package com.cucumberFramework.stepdefinitions;

import org.apache.log4j.Logger;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.testBase.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ServiceHooks {

	TestBase testBase;

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() {
		testBase = new TestBase();		
		testBase.initialization();
	}

	@After
	public void endTest() {
		TestBase.driver.quit();
	}
}
