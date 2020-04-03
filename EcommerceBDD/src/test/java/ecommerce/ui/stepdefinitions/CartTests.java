package ecommerce.ui.stepdefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.epam.utilities.ElementHighliter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommerce.pages.CartPage;
import ecommerce.pages.CategoryPage;
import ecommerce.pages.ProductsPage;
import ecommerce.pages.SubCategory;

public class CartTests extends BaseTestClass {
	static SubCategory subcategory;
	static ProductsPage product;
	static CartPage cart;
	@Given("^open the url$")
	public void open_the_url() throws Throwable {
		
	}
	@When("^click on the desired category$")
	public void click_on_the_desired_category() throws Throwable {
		CategoryPage category = new CategoryPage(driver);
		
		category.selectCategory("Electronics");
	}

	@When("^select the product and quantity$")
	public void select_the_product_and_quantity() throws Throwable {
		subcategory = new SubCategory(driver);
		subcategory.selectSubcategory("Mobiles");
		product = new ProductsPage(driver);
		product.selectProduct("ONEPLUS", "1");
	}

	@Then("^that product should be added to cart$")
	public void that_product_should_be_added_to_cart() throws Throwable {
		boolean isProductAddedToCart = product.isProductAddedToCart();
		Assert.assertTrue(isProductAddedToCart);
		driver.navigate().back();
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;

	}
	
	//invalid quantity
	@When("^select the product and give invalid quantity$")
	public void select_the_product_and_give_invalid_quantity() throws Throwable {
		subcategory.selectSubcategory("Mobiles");
		product.selectProduct("IPHONEX", "0");
		
	}
	
	

	@Then("^it should show erro message$")
	public void it_should_show_erro_message() throws Throwable {
		boolean isProductAddedToCart = product.isProductAddedToCart();
		Assert.assertFalse(isProductAddedToCart);
	}
	
	// updating cart quantity through text box
	@When("^click on cart$")
	public void click_on_cart() throws Throwable {
		cart=new CartPage(driver);
		cart.gotoCart(); 
	}

	@When("^update the product's quantity$")
	public void update_the_product_s_quantity() throws Throwable {
		cart.setQuantity("4");
		
		
	}

	@Then("^quantity should be updated$")
	public void quantity_should_be_updated() throws Throwable {
		boolean isupdated=cart.updateQuantity();
		Assert.assertTrue(isupdated);
	}

}
