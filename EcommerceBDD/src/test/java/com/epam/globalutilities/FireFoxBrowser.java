package com.epam.globalutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser implements BrowserFactory {

	public WebDriver getBrowserDriver( ) {
		
		return new FirefoxDriver();
	}

}

