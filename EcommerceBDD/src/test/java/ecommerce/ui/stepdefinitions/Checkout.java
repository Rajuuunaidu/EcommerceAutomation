package ecommerce.ui.stepdefinitions;


import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommerce.pages.CartPage;

public class Checkout extends BaseTestClass {
	static CartPage  cartpage=new CartPage(driver);
	boolean isItemsCheckedOut;
	@When("^Navigate to cartPage and click on check out button$")
	public void navigate_to_cartPage_and_click_on_check_out_button() throws Throwable {
		cartpage.gotoCart();
		 isItemsCheckedOut=cartpage.checkOut();
		
	}

	@Then("^all products need to be checked out$")
	public void all_products_need_to_be_checked_out() throws Throwable {
		Assert.assertTrue(isItemsCheckedOut);
	}


}
