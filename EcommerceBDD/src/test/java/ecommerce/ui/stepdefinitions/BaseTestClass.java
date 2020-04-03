package ecommerce.ui.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.globalutilities.BrowserFactoryImpl;
import com.epam.utilities.ReadProperties;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BaseTestClass {
	public static WebDriver driver;
	Properties properties = new Properties();
	
	@BeforeClass
	public static void setUp() throws IOException {

		String browser = ReadProperties.getBrowser();
		driver = (BrowserFactoryImpl.browserType(browser)).getBrowserDriver();
		String baseUrl = ReadProperties.getBaseUrl();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
