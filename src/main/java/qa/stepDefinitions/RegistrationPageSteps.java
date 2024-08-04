package qa.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.Bookingcase;
import pages.RegistrationPage;
import util.TestBase;

public class RegistrationPageSteps extends TestBase {
	
	RegistrationPage registers; 
	Bookingcase booking;
	
	
	@Given("Go To Website Link Staples.com")
	public void go_to_website_link_staples_com() {
		
		TestBase.initialization();
	}
	@Then("Create Account")
	public void create_account() throws Exception {
		registers = new RegistrationPage();
	    registers.newaccount();
	}
	@Then("Enter Invalid details to Register such as \"(.*)\", \"(.*)\",\"(.*)\",\"(.*)\" and \"(.*)\"$")
	public void enter_invalid_details_to_register_such_as_and(String Email, String FirstName, String striLastNameng3, String PhoneNumber , String Password) {
	    registers.entervalues("abd@cd", "Dinesh", "Seth", "97339343", "test5");
	}
	@Then("Verify  error message in Email field")
	public void verify_error_message_in_email_field() {
	   Boolean register= registers.validateemaildisplays();
	   Assert.assertTrue(register);
	   String emailtext =registers.validateinvalidemail();
	    Assert.assertEquals("Invalid email address", emailtext);
	}
	@Then("Verify  error message in Phone number")
	public void verify_error_message_in_phone_number() {
		
		Boolean phoneno = registers.validatephonedisplays();
		 Assert.assertTrue(phoneno);
		 String phonenumber=registers.validateinvalidphone();
		 Assert.assertEquals("Please enter a valid phone number.", phonenumber);
	    
	}
	@Then("Verify error message in password")
	public void verify_error_message_in_password() {
	    Boolean pass = registers.validatepassworddisplays();
	    Assert.assertTrue(pass);
	    String passwordText= registers.validateInvalidpassword();
	    Assert.assertEquals("Password must contain at least 8 characters", passwordText);
	}
	
	@Given("Enter Valid Details")
	public void enter_valid_details() {
		registers = new RegistrationPage();
	   registers.Entervalidvalues();
	}
	
	@Then("Verify if user gets Logged in")
	public void verify_if_user_gets_logged_in() {
		Boolean successfullogin=registers.verifyuserLogin();
		Assert.assertTrue(successfullogin);
		
}
	@Given("Enter search value in search Bar and search")
	public void enter_search_value_in_search_bar_and_search() {
		
		
		booking = new Bookingcase();
	    booking.searchvalue();
	}
	
	@Then("In the selected product page click on Add to cart")
	public void in_the_selected_product_page_click_on_add_to_cart() throws Exception {
		booking.addtocart();
	}
	@Then("Verify that same product is added in Add to cart")
	public void verify_that_same_product_ios_added_in_add_to_cart() {
	  String productvalue=  booking.productdisplay();
	  if(productvalue.contains("HP OfficeJet")) {
		  //System.out.println("Item is addedd to addto cart page");
		  Assert.assertTrue(true);
	  }
	}
	@Then("Verify Cart Subtotal value")
	public void verify_cart_subtotal_value() {
	    String cartval= booking.cartvalue();
	    System.out.println(cartval);
	    booking.checkoutpage();
	}


	
	

}
