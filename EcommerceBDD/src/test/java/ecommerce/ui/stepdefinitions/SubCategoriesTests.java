package ecommerce.ui.stepdefinitions;



import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommerce.pages.CategoryPage;
import ecommerce.pages.SubCategory;

public class SubCategoriesTests extends BaseTestClass{
	static SubCategory subcategory;
	boolean isDisplayed;
	static CategoryPage category;
	@When("^check is category Electronics then Mobiles,HomeAppliances is displayed$")
	public void check_is_category_Electronics_then_Mobiles_HomeAppliances_is_displayed() throws Throwable {
		category=new CategoryPage(driver);
		subcategory = new SubCategory(driver);
		category.selectCategory("Electronics");
		isDisplayed = subcategory.isDisplayed("Mobiles");
		Assert.assertTrue(isDisplayed);
		isDisplayed = subcategory.isDisplayed("HomeAppliances");
		Assert.assertTrue(isDisplayed);
		driver.navigate().back();
		
	}

	@When("^check is category fashion then Men,Women,Kids is displayed$")
	public void check_is_category_fashion_then_Men_Women_Kids_is_displayed() throws Throwable {
		//subcategory = new SubCategory(driver);
		category.selectCategory("Fashion");
		isDisplayed = subcategory.isDisplayed("Men");
		Assert.assertTrue(isDisplayed);
		isDisplayed = subcategory.isDisplayed("Women");
		Assert.assertTrue(isDisplayed);
		
	}
	@Then("^subcategory should be displayed$")
	public void subcategory_should_be_displayed() throws Throwable {
	}

	
}
