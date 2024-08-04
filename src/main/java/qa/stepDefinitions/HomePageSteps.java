package qa.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import pages.LoginPage;
import util.TestBase;

public class HomePageSteps extends TestBase{
	 
	LoginPage loginpage ;

	@Given("Go To  Link Staples.com")
	public void go_to_link_staples_com() {
		TestBase.initialization();
	}
	@Then("Enter Invalid details to Login such as \"(.*)\", and \"(.*)\"$")
	public void enter_invalid_details_to_login_such_as_and(String Email, String Password ) throws Exception {
		loginpage =new LoginPage();
		loginpage.login("abd@cd", "test5 ");
		
	}
	@Then("Verify  error message")
	public void verify_error_message() {
		String errmsg=loginpage.error();
		Assert.assertEquals("We're sorry, but this username and password combination does not match our records. If you do not have a Staples.com account, you will need to create one.", errmsg);
		
	}
	@Given("Enter Valid Credentials")
	public void enter_valid_credentials() throws Exception {
	    loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
