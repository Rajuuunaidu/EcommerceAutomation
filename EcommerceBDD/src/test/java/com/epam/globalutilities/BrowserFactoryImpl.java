package com.epam.globalutilities;

public class BrowserFactoryImpl  {

	public static BrowserFactory browserType(String browser) {
		String projectPath=System.getProperty("user.dir");
		
		if (browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromedriver.exe");
			return new Chromebrowser();
		}
		else if (browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver.exe");
			return  new FireFoxBrowser();
		}
		return null;
	}
}

