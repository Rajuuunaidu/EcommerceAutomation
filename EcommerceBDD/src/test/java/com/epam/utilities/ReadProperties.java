package com.epam.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	

	static Properties properties = new Properties();
	
	static String propertiesPath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";

	public static String getBrowser() throws IOException {

		properties.load(new FileInputStream(new File(propertiesPath)));
		return properties.getProperty("browser");
	}

	public static String getBaseUrl() throws IOException {
		properties.load(new FileInputStream(new File(propertiesPath)));
		return properties.getProperty("baseUrl");

	}

}
