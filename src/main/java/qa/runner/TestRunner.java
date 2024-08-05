package qa.runner;


import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.*;


//@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\ANGEL\\eclipse-workspace\\InterviewStaples\\src\\main\\java\\qa\\features\\Login.feature",
		"C:\\Users\\ANGEL\\eclipse-workspace\\InterviewStaples\\src\\main\\java\\qa\\features\\Registrationbooking.feature"},
                            glue = {"qa/stepDefinitions"},
                            plugin = {"pretty","html:target/cucumber-report","json:target/cucumber-json","junit:junit_xml/cucumber.xml"}, 
                            monochrome = true,
                            dryRun = false
                            )

//

public class TestRunner extends AbstractTestNGCucumberTests{

	
	 @DataProvider(parallel =true)
	    public Object[][] scenario(){
			
			return super.scenarios();
		} //return testNGCucumberRunner.providedFeatures();
		 
}
