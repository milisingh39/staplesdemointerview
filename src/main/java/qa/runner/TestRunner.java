package qa.runner;


import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.*;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\ANGEL\\eclipse-workspace\\MyprojectFrame\\src\\main\\java\\qa\\features" 
                            ,glue = {"qa/stepDefinitions"},
                            plugin = {"pretty","html:target/cucumber-report","json:target/cucumber-json","junit:junit_xml/cucumber.xml"}, 
                            monochrome = false,

                            dryRun = false
                            )

//

public class TestRunner extends AbstractTestNGCucumberTests{
//   private TestNGCucumberRunner testNGCucumberRunner;
//	
//	@BeforeClass(alwaysRun = true)
//	public void SetUpClass() throws Exception{
//		testNGCucumberRunner =new TestNGCucumberRunner(this.getClass());
//		
//	}
//	
//	@Test(groups="Cucumber", description ="Runs Cucumber Feature", dataProvider="features")
//	public void feature(CucumberFeatureWrapper cucumberfeature) {
//		
//		testNGCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
//	}
	
	 @DataProvider(parallel =true)
	    public Object[][] scenario(){
			
			return super.scenarios();
		} //return testNGCucumberRunner.providedFeatures();
		 
}
