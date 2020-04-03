package ecommerce.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class CheckOutTest {
	Response response;
	List<String> categoryList;
	List<String> productList;
	List<String> orderList;
	Map<String, Integer> cartItemId;
	Map<String, Integer> cart;
	Map<String, Integer> cartQuantityUpdate;
	Map<String, Integer> removalFromCart;
	@When("^made a delete request for users (\\d+)  cart$")
	public void made_a_delete_request_for_users_cart(int userID) throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/orders/all";
		response = given().when().post(url);
		Utils.setResponse(response);
	}

	@Then("^all the products should be placed$")
	public void all_the_products_should_be_placed() throws Throwable {
		String isCheckedOut = response.getBody().asString();
		System.out.println(isCheckedOut);
		Assert.assertEquals("true", isCheckedOut);
	}
	

}
