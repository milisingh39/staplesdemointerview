
@FunctionalTest
Feature: Registration Functionality
 

  
   Scenario Outline: Registration With Invalid details
     Given Go To Website Link Staples.com
     Then Create Account
     And Enter Invalid details to Register such as "<Email>", "<FirstName>","<LastName>","<Phone Number>" and "<Password>"
     Then Verify  error message in Email field
     Then Verify  error message in Phone number
     Then Verify error message in password
     
     Examples: 
      | Email  | FirstName      | LastName | Phone Number | Password  |
      | abd@cd |     Dinesh    | Seth        |78888       |  test5    | 
     
      
     

  
  Scenario: Registration With Valid details
    Given Enter Valid Details 
    And    Verify if user gets Logged in
    
    
   


  Scenario: Search with a value and Add a product to Add to cart Page
    Given Enter search value in search Bar and search
    Then  In the selected product page click on Add to cart
    Then  Verify that same product is added in Add to cart
    Then  Verify Cart Subtotal value
    

    
