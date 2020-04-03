package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.ElementHighliter;


public class SubCategory {
	enum subcategory 
	{ 
	    Mobiles,HomeAppliances,Women,Men; 
	} 
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Mobiles')]")
	WebElement mobiles;
	@FindBy(xpath = "//a[contains(text(),'Home Applicances')]")
	WebElement homeAppliances;
	@FindBy(xpath = "//a[contains(text(),'Women')]")
	WebElement women;
	@FindBy(xpath = "//a[contains(text(),'Men')]")
	WebElement men;

	public void selectSubcategory(String scategory) {
		subcategory subCategoryName=subcategory.valueOf(scategory);
		switch (subCategoryName) {
		case Mobiles:
			ElementHighliter.highlite(driver, mobiles);
			mobiles.click();
			break;
		case HomeAppliances:
			ElementHighliter.highlite(driver, homeAppliances);
			homeAppliances.click();
			break;
		case Women:
			ElementHighliter.highlite(driver, women);
			women.click();
			break;
		case Men:
			ElementHighliter.highlite(driver, men);
			men.click();
			break;
		}
	}
	public boolean isDisplayed(String scategory) {
		boolean isdisplayed=false;
		BasePageClass bp=new BasePageClass(driver);
			subcategory subCategoryName=subcategory.valueOf(scategory);
			switch (subCategoryName) {
			case Mobiles:
				isdisplayed= bp.isDisplayed(mobiles);
				break;
			case HomeAppliances:
				isdisplayed= bp.isDisplayed(homeAppliances);
				break;
			case Women:
				isdisplayed= bp.isDisplayed(women);
				break;
			case Men:
				isdisplayed= bp.isDisplayed(men);
				break;
			}
			return isdisplayed;
	}
	public SubCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
