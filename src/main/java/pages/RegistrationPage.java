package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class RegistrationPage extends TestBase{
	
	@FindBy(xpath="//iframe[@name='trustarc_cm']")
	WebElement iframe;

	@FindBy(xpath="//a[@class='call']")
	WebElement iagree;
	
	@FindBy(xpath="//span[contains(@class,'navigation')]/span[text()='Sign in']")
	WebElement signinicon;
	
	@FindBy(xpath="//div[contains(@class,'navigation')]/span[text()='Create Account']")
	WebElement createacct;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@type='phone']")
	WebElement phonenum;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwd;

	@FindBy(xpath="//span[text()='Create account']")
	WebElement createaccButton;
	
	@FindBy(xpath="//*[text()='Invalid email address']")
	WebElement invalidemail;
	
	@FindBy(xpath="//*[text()='Please enter a valid phone number.']")
	WebElement invalidphno;
	
	@FindBy(xpath ="//*[contains(text(),'Password must contain')]")
	WebElement invalidpwd;
	
    @FindBy(xpath ="//span[text()='Atul Seth']")
	WebElement verifytext;
    
    @FindBy(id="Shop now button")
  	WebElement shopnowbutton;
    
  
    @FindBy(xpath ="//div[@class='navigation-menu-item__customerName']")
	WebElement customername;
	
	
      public RegistrationPage() {
		
		PageFactory.initElements(driver,this);
	     }
	
	public void newaccount() throws Exception {
		//Handling Frames
		
		driver.switchTo().frame(iframe);
		iagree.click();
		driver.switchTo().defaultContent();
		// CLick on Create Account

		Thread.sleep(15000);
		signinicon.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", createacct);
		
		   
		  // createacct.sendKeys(email); 
	}
	
	public void entervalues(String Email, String firstnm, String lastnm, String phoneno, String password) {
	   email.sendKeys(Email);
	   firstname.sendKeys(firstnm);
	   lastname.sendKeys(lastnm);
	   phonenum.sendKeys(phoneno);
	   passwd.sendKeys(password);
	  // createaccButton.click();
	  
	 }
	
	public Boolean validateemaildisplays() {
		return invalidemail.isDisplayed();
	    
		
	}
	public String validateinvalidemail() {
		
		return invalidemail.getText();
	}
	
	
	public Boolean validatephonedisplays() {
		return invalidphno.isDisplayed();
	    
		
	}
	public String validateinvalidphone() {
		
		return invalidphno.getText();
	}
	
	
	public Boolean validatepassworddisplays() {
		return invalidpwd.isDisplayed();
	    
		
	}
	public String validateInvalidpassword() {
		
		return invalidpwd.getText();
	}
	public void Entervalidvalues() {
		   String emailid = "Atul.seth" + Math.random() + "@staple.com";
		   email.clear();
		   email.sendKeys(emailid);
		   firstname.clear();
		   firstname.sendKeys(prop.getProperty("firstname"));
		   lastname.clear();
		   lastname.sendKeys(prop.getProperty("lastname"));
		   phonenum.clear();
		   phonenum.sendKeys(prop.getProperty("phoneno"));
		   passwd.clear();
		   passwd.sendKeys(prop.getProperty("passwd"));
		  createaccButton.click();
		  shopnowbutton.click();
		 }
	
	public Boolean verifyuserLogin() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", customername);
		return verifytext.isDisplayed();
		
	
	}
	
	

}
