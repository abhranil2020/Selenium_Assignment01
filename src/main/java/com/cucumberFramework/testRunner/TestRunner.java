package com.cucumberFramework.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@CucumberOptions(features = {"src/test/resources/features/login/login_logout_ValidCred.feature","src/test/resources/features/login/login_Invalidcred.feature" },
glue = { "com/cucumberFramework/stepdefinitions" }, 
plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" },
 dryRun = false,monochrome = true)

public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	@Description("Stackover Login and logout with valid & Invalid credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Feature("Feature 1: As a Stackover user I should be able to login and logout with valid credentials "	+ "  " +" Feature 2:As a Stackover user I shouldnot able to login with In-valid credentials and error message should display")
	@Story("Stackover Login and logout")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@Description("Closing the Browser")
	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}

}
