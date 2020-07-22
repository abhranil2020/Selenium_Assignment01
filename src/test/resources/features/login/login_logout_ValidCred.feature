Feature: As a Stackover user I should be able to login and logout with valid credentials
   
 Scenario Outline: Sucessfull login with Valid Credentials
 
    Given User Invoke URL"https://stackoverflow.com/"
    Then User Click on Log in button and wait for sign in page
    When User Enter Email address as "<Email>" and Password as "<Password>".
    And  Click on Log in button
    Then StackOverflow link should be displayed
    And  Tag link should be displayed
    When User click on Logout button
    Then I got log out from the application and land on sign in page

    Examples: 
      | Email|Password| 
      | abhranil.blr@gmail.com | April2020#	|       
      
      