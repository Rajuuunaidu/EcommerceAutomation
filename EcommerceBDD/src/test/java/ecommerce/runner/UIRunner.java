package ecommerce.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;
import ecommerce.ui.stepdefinitions.BaseTestClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:UIAutomation/cart.feature" }, glue = "ecommerce.ui.stepdefinitions",

		plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:C:\\Users\\Raju_Pyla\\eclipse-workspace\\EcommerceBDD\\Reports\\report.html" })

public class UIRunner extends BaseTestClass {
	
	@AfterClass
	public static void reportSetup() {
		Reporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("64 Bit", "Windows 10");
		Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
	}

	
	
	
}
