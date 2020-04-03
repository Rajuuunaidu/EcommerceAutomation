package ecommerce.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { 
		"classpath:cartFeature.feature" }, glue = "ecommerce.stepdefinitions")
				
public class RestApiRunner {
	

}
