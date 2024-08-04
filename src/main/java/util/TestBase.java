package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream("./src/main/java/config/config.properties");
			prop.load(fs);
		} catch (IOException e) {
			e.getMessage();
		}

	}

	
	public static void initialization() {
		String browserName = prop.getProperty("browserName");

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}else
			{
				
				System.out.println("No Matching browser found for  " + prop.getProperty("browserName"));
			}
		
//			 WebDriverManager.chromedriver().setup();
//			 WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
	
	
	

	}


