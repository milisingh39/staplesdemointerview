package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//iframe[@name='trustarc_cm']")
	WebElement iframe;
	
	@FindBy(xpath="//a[@class='call']")
	WebElement iagree;
	
	@FindBy(xpath="//span[contains(@class,'navigation')]/span[text()='Sign in']")
	WebElement signinicon;
	
	@FindBy(xpath ="//button[@aria-label='Sign in']")
	WebElement SigninButton;
	
	@FindBy(id ="loginUsername")
	WebElement username;
	
	@FindBy(id="loginPassword")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@id='dotcom_login_error_notification']")
	WebElement errormssg;

	
	

	
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public void signinicon() throws InterruptedException  {
		
	        driver.switchTo().frame(iframe);
			iagree.click();
			driver.switchTo().defaultContent();
		  Thread.sleep(5000);
			//signinicon.click();
			////WebDriverWait wait = new WebDriverWait(driver,DurationsofSeconds(30));
			// wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'navigation')]/span[text()='Sign in']"))));
		 
			JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", signinicon);
			//Actions a =new Actions(driver);
			//a.moveToElement(signinicon).doubleClick().build().perform();
			SigninButton.click();
		
	}
	

	
	private Duration DurationsofSeconds(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void login(String un, String pwd) throws Exception {
		signinicon();
		driver.manage().deleteAllCookies();
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", loginbtn);
	
	}
	
	public String error() {
		return errormssg.getText();
		
	}
	
	     
   }
