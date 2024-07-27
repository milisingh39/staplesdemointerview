package qa.stepDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import util.TestBase;

public class HomePageSteps extends TestBase{
	 
	LoginPage loginpage ;
	HomePage homepage;
	
	@Given("^User opens browser$")
	public void user_opens_browser() {
	   TestBase.initialization();
	}
	@SuppressWarnings("deprecation")
	@Then("^User is on Login Page$")
	public void user_is_on_login_page() {
		loginpage =new LoginPage();
	    String title=loginpage.validateLoginPageTitle();
	    Assert.assertEquals("Cogmento CRM", title);
	}
	@Then("^User enters username and password$")
	public void user_enters_username_and_password() throws Exception {
	   homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Then("^Validate Home Page title$")
	public void validate_home_page_title() {
		String hometitle = homepage.verifyHomePageTitle();
		  
		   Assert.assertEquals("Cogmento CRM", hometitle);
	}
	@Then("^validate Logged in username$")
	public void validate_logged_in_username() {
	   boolean usernm= homepage.verifyCorrectUserNamee();
	   Assert.assertTrue(usernm);
	   driver.quit();
	}


}
