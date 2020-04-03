package ecommerce.ui.stepdefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommerce.pages.CategoryPage;

public class CategoryTests extends BaseTestClass {
	static CategoryPage category;
	boolean isDisplayed;

	@When("^check is category Electronics is displayed$")
	public void check_is_category_Electronics_is_displayed() throws Throwable {
		category = new CategoryPage(driver);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		isDisplayed = category.isDisplayed("Electronics");
	}

	@When("^check is category fashion is displayed$")
	public void check_is_category_fashion_is_displayed() throws Throwable {
		isDisplayed = category.isDisplayed("Fashion");
	}

	@When("^check is category mens_shoes is displayed$")
	public void check_is_category_mens_shoes_is_displayed() throws Throwable {
		isDisplayed = category.isDisplayed("mens_shoes");

		
	}

	@Then("^it should be  displayed$")
	public void it_should_be_displayed() throws Throwable {
		Assert.assertTrue(isDisplayed);
	}

}
