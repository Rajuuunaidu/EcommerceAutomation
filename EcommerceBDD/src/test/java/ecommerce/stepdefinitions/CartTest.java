package ecommerce.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CartTest{
	Response response;
	List<String> categoryList;
	List<String> productList;
	List<String> orderList;
	Map<String, Integer> cartItemId;
	Map<String, Integer> cart;
	Map<String, Integer> cartQuantityUpdate;
	Map<String, Integer> removalFromCart;
	int cartId;
	@When("^choose the product , quantity and made a post request for user (\\d+)$")
	public void choose_the_product_quantity_and_made_a_post_request_for_user(int userID, DataTable table)
			throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/cart";
		cart = new HashMap<String, Integer>();
		for (DataTableRow tab : table.getGherkinRows())
			cart.put(tab.getCells().get(0), Integer.parseInt(tab.getCells().get(1)));
		System.out.println(cart);
		response = given().contentType(ContentType.JSON).body(cart).when().post(url);
		Utils.setResponse(response);

		
	}

	@Then("^product should be added to cart$")
	public void product_should_be_added_to_cart() throws Throwable {

		JsonPath js = response.jsonPath();

		int productId = Integer.parseInt(js.getString("responseObject.productId"));
		System.out.println(productId);
		Assert.assertTrue(cart.containsValue(productId));

	}
	@When("^made a post request for user (\\d+) and update quantity (\\d+) for the cart (\\d+)$")
	public void made_a_post_request_for_user_and_update_quantity_for_the_cart(int userId, int quantity, int cartItemId)
			throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userId + "/cart/" + cartItemId;
		System.out.println(url);
		cartQuantityUpdate = new HashMap<String, Integer>();
		cartQuantityUpdate.put("cartItemId", cartItemId);
		cartQuantityUpdate.put("quantity", quantity);

		response = given().contentType(ContentType.JSON).body(cartQuantityUpdate).when().put(url);
		Utils.setResponse(response);
	}

	@Then("^cart product quantity should be updated$")
	public void cart_product_quantity_should_be_updated() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");

		Assert.assertEquals("Success", status);
	}
	@When("^made  post request for user (\\d+) and update quantity -(\\d+) for the cart (\\d+)$")
	public void made_post_request_for_user_and_update_quantity_for_the_cart(int userId, int quantity, int cartItemId)
			throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userId + "/cart/" + cartItemId;
		System.out.println(url);
		cartQuantityUpdate = new HashMap<String, Integer>();
		cartQuantityUpdate.put("cartItemId", cartItemId);
		cartQuantityUpdate.put("quantity", -quantity);
		response = given().contentType(ContentType.JSON).body(cartQuantityUpdate).when().put(url);
		Utils.setResponse(response);
	}

	@Then("^should show warning message$")
	public void should_show_warning_message() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");
		Assert.assertEquals("InvalidQuantity", status);
	}
	@When("^made a get request for the cart products for user (\\d+)$")
	public void made_a_get_request_for_the_cart_products_for_user(int userID) throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/cart";
		response = given().when().get(url);
		Utils.setResponse(response);

	}

	@Then("^all products should be fetched$")
	public void all_products_should_be_fetched() throws Throwable {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

}
