package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class Bookingcase extends TestBase {
	
	@FindBy(id="searchInput")
	WebElement searchbar;
	
	@FindBy(xpath="//a[contains(@href,'officejet')]")
	WebElement product;
	
	@FindBy(xpath="//button[contains(@aria-label,'Add 2 items to cart')]")
	WebElement addtocart;
	
	@FindBy(xpath="//*[contains(text(),'HP OfficeJet Pro 8135e Wireless All-in-One Color Inkjet Printer Scanner Copier, ')]")
	WebElement verifyproduct;
	
	
	@FindBy(xpath="//div[contains(@class,'navigation-menu-item__cartBubbleIcon')]")
	WebElement carticon;
	
	
	@FindBy(xpath="//div[contains(@class,'cart_sub_total')]")
	WebElement cartText;
	
	@FindBy(xpath="//span[contains(text(),'Checkout')]")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//h1[@class= 'checkout-layout__header_title']")
	WebElement checkoutpageheader;
	
	public Bookingcase() {
		
		PageFactory.initElements(driver,this);
	}
	
	public void searchvalue() {
		searchbar.click();
		searchbar.sendKeys("Printer");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		product.click();
		
		
	}
	
	public void addtocart() throws Exception {
		//Thread.sleep(1500);
		//product.click();
		//addtocart.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", addtocart);
		
		
	}
	
	public String productdisplay() {
		
		return verifyproduct.getText();
	}
	
	public String cartvalue() {
		
		return cartText.getText();
	}
	public void checkoutpage() {
		checkoutbtn.click();
	}
	
	

}
