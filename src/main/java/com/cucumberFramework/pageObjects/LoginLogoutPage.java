package com.cucumberFramework.pageObjects;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumberFramework.helper.WaitHelper;

import io.qameta.allure.Step;


public class LoginLogoutPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//li/*[text()='Log in']")	
	WebElement homeloginbutton	; // login button	
	
	@FindBy(xpath = "//li/*[text()='Sign up']")	
	WebElement Signupbutton	; // Sign up button		
		
	@FindBy(xpath = ".//*[@id='email']")	
	WebElement emailtextbox	; // Enter email text box	
	
	@FindBy(xpath = ".//*[@id='password']")	
	WebElement passwordtextbox	; // Enter password text box	
		
	@FindBy(xpath = "//div/*[text()='Log in']")	
	WebElement loginbutton	; // login button
	
	@FindBy(xpath = "//a[@id='nav-questions']/*[text()='Stack Overflow']")	
	public WebElement StackOverflowlink	; // Stack Overflow link on LHS
	
	@FindBy(xpath = "//ol/li/a[contains(text(),'Tags')]")	
	public WebElement Tagslink	; // Stack Tags link link on LHS
	
	@FindBy(xpath = "//a[@title='A list of all 177 Stack Exchange sites']")	
	WebElement logoutnav	; 

	@FindBy(xpath = "//a[text()='log out']")	
	WebElement logoutbutton	; // logout button in home page
	
	@FindBy(xpath = "//div/button[text()='Log out']")	
	WebElement Finallogout	; // logout button in next page
	
	@FindBy(xpath = "//div[1]/p[contains(text(),'The email is not a valid email address.')]")	
	WebElement ActualErrormsg	; // Error Message 
	
	
	WaitHelper waitHelper;
	
	public LoginLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	
	
	@Step("User Click on log-in button in Slockover flow page")
		public void homeloginbutton() throws Exception {			
				homeloginbutton.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);			}
		
	@Step("User entering User name & password in Sign-In Page")
		public void stackoverflowuserlogin(String username, String password) {		
			emailtextbox.clear();
			emailtextbox.sendKeys(username);
			passwordtextbox.clear();
			passwordtextbox.sendKeys(password);		}	
		
	
	@Step("User Click on log-in button in Sign-In Page")
		public void Clicklogin() {
			loginbutton.click();	
		}
			
	public void homepagetitle(String expectedinboxpageTitle){
				System.out.println("Verifying homepage Title");			
				String actualHomePageTitle = driver.getTitle();
				Assert.assertTrue(actualHomePageTitle.startsWith(expectedinboxpageTitle));
				driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);			
			}
			
		@Step("Verifying StackOverflow link is present & enabled in User home page")
			public void verifyingStackOverflowlink(){			
				if(StackOverflowlink.isDisplayed()&& StackOverflowlink.isEnabled()){
					System.out.println("StackOver flow link is Present in home page");  }
				else{
					System.out.println("StackOver flow link is Not Present in home page");	}			
			}	

		@Step("Verifying Tag link is present & enabled in User home page")
			public void verifyingtaglink(){			
				if(Tagslink.isDisplayed()&& Tagslink.isEnabled()){
					System.out.println("Tags link is Present in home page");}
				else {
					System.out.println("Tags link is Not Present in home page");}											
			}	
			
		@Step("User Click on log-Out button in Sign-In Page")
			public void Clicklogout()
			{
				logoutnav.click();
				logoutbutton.click();
				Finallogout.click();			
				System.out.println("Logout is Sucessfull");				
			}
		
		@Step("Verifying log-in & Signupbutton button present in Slockover flow page")
			public void logoutfrom_application()			{		
				if(homeloginbutton.isDisplayed() && Signupbutton.isDisplayed())			{
					System.out.println("log out from the application and land on sign in page");
				}
				else {
					System.out.println("Error page");
				}
			}
						
			/*public void verifyingerrormsg(String expectederrormsg){
				String Result=ActualErrormsg.getText();
				System.out.println(Result);	
				Assert.assertEquals(Result, expectederrormsg);
			}	*/
	
}
