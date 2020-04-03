package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.ElementHighliter;

public class CategoryPage {
	enum category 
	{ 
	    Electronics,Fashion,mens_shoes; 
	} 
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Electronics')]")
	WebElement electronics;
	@FindBy(xpath = "//a[contains(text(),'Fashion')]")
	WebElement fashion;
	@FindBy(xpath = "//a[contains(text(),'mens_shoes')]")
	WebElement mens_shoes;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCategory(String str) {
		category categoryName=category.valueOf(str);
		switch (categoryName) {
		case Electronics:
			ElementHighliter.highlite(driver, electronics);
			electronics.click();
			break;
		case Fashion:
			ElementHighliter.highlite(driver,fashion );
			fashion.click();
			break;
		case mens_shoes:
			ElementHighliter.highlite(driver, electronics);
			mens_shoes.click();
			break;
		}
	}
	public boolean isDisplayed(String str) {
		boolean isdisplayed=false;
		category categoryName=category.valueOf(str);
		BasePageClass bp=new BasePageClass(driver);
		switch (categoryName) {
		case Electronics:
			isdisplayed= bp.isDisplayed(electronics);
			break;
		case Fashion:
			isdisplayed= bp.isDisplayed(fashion);
			break;
		case mens_shoes:
			isdisplayed= bp.isDisplayed(mens_shoes);
			break;
		}
		return isdisplayed;
	}
}
