package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageClass {
	WebDriver driver;
	BasePageClass(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

}
