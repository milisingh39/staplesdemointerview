package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath ="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type ='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//span[contains(@class,'icon-xs')]")
	WebElement Loginicon;
	
	@FindBy(xpath ="//div[contains(@class,' submit button')]")
	WebElement loginbutton;

	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) throws Exception {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", loginbtn);
		
		return new HomePage();
	}
	
	     
   }
