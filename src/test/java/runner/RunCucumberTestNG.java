package runner;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features", 
	    glue = "",
	    	    monochrome = true,
	    	    tags = "",
	    	    plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
	)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests{
	
	//convert feature file scenario into testng test
	@DataProvider(parallel = true)  //false 
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before execution of suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After execution of suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("Result : "+result);
		System.out.println("Name : "+result.getName());
		System.out.println("Test Name : "+result.getTestName());
		int resultStatus = result.getStatus();
		System.out.println("resultStatus : " +resultStatus);
	}
}