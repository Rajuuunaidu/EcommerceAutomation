package com.epam.globalutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromebrowser implements BrowserFactory{

	public WebDriver getBrowserDriver( ) {
		
		return new ChromeDriver();
	}

}
