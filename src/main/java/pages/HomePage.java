package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Mili Singh')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deals')]")
	WebElement newContactLink;
	
//	@FindBy(xpath="//a[contains(text(),'Deals')]")
//	WebElement dealsLink;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public Boolean  verifyCorrectUserNamee() {
		return userNameLabel.isDisplayed();
	}
	
	
	public void clickOnNewContactLink() {
		
		Actions action =new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
