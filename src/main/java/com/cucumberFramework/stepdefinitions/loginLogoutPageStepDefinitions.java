package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.LoginLogoutPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginLogoutPageStepDefinitions extends TestBase {

	LoginLogoutPage loginPage = new LoginLogoutPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^User Invoke URL\"([^\"]*)\"$")
	public void user_Invoke_URL(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Then("^User Click on Log in button and wait for sign in page$")
	public void user_Click_on_Log_in_button_and_wait_for_sign_in_page() throws Throwable {
		loginPage.homeloginbutton();
				
	}

	@When("^User Enter Email address as \"([^\"]*)\" and Password as \"([^\"]*)\"\\.$")
	public void user_Enter_Email_address_as_and_Password_as(String arg1, String arg2) throws Throwable {
		loginPage.stackoverflowuserlogin(arg1, arg2);
	}

	@When("^Click on Log in button$")
	public void click_on_Log_in_button() throws Throwable {
		loginPage.Clicklogin();	
		Thread.sleep(3000);		
	}

	@Then("^StackOverflow link should be displayed$")
	public void stackoverflow_link_should_be_displayed() throws Throwable {
		waitHelper.WaitForElement(loginPage.StackOverflowlink, 60);
		waitHelper.WaitForElement(loginPage.Tagslink, 60);
		loginPage.verifyingStackOverflowlink();
	}

	@Then("^Tag link should be displayed$")
	public void tag_link_should_be_displayed() throws Throwable {

		loginPage.verifyingtaglink();
	}

	@When("^User click on Logout button$")
	public void user_click_on_Logout_button() throws Throwable {
		loginPage.Clicklogout();
	}

	@Then("^I got log out from the application and land on sign in page$")
	public void i_got_log_out_from_the_application_and_land_on_sign_in_page() throws Throwable {

		loginPage.logoutfrom_application();
		
	}
	
}