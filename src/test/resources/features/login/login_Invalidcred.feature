Feature: As a Stackover user I shouldnot able to login with In-valid credentials and error message should display
   
 Scenario Outline: Login with In-Valid Credentials
 
    Given User Invoke URL"https://stackoverflow.com/"
    Then User Click on Log in button and wait for sign in page
    When User Enter Email address as "<Email>" and Password as "<Password>".
    And  Click on Log in button
 
    Examples: 
      | Email|Password| 
      | abhranil.blr@gmail.com | March2020#	|     