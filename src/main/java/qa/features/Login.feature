@FunctionalTest
Feature: Login Functionality
 

  
   Scenario Outline: Login With Invalid details
     Given Go To  Link Staples.com
     Then Enter Invalid details to Login such as "<Email>", and "<Password>"
     Then Verify  error message 
     
     
     Examples: 
      | Email  |  Password  |
      | abd@cd |  test5    | 

   Scenario: Login With Valid credentials
    Given Enter Valid Credentials 
  
    

 
