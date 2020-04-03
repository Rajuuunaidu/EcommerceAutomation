package ecommerce.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class SubCategoriesTest {
	String url;
	Response response;
	List<String> categoryList;
	List<String> productList;
	List<String> orderList;
	Map<String, Integer> cartItemId;
	Map<String, Integer> cart;
	Map<String, Integer> cartQuantityUpdate;
	Map<String, Integer> removalFromCart;
	int cartId;
static int i=1;
	@Given("^api are up and running for \"([^\"]*)\"$")
	public void api_are_up_and_running_for(String url) throws Throwable {
		Utils.setUrl(url);
	}

	@When("^made request for the categories  (\\d+)$")
	public void made_request_for_the_categories(int categoryID) throws Throwable {
		url=Utils.getUrl();
		url = url + "category/" + categoryID + "/sub-category";
		System.out.println("url"+url);
		
		response = given().when().get(url);
		Utils.setResponse(response);
	}

	@When("^responce code should be (\\d+)$")
	public void responce_code_should_be(int responseCode) throws Throwable {
		response=Utils.getResponse();
		Assert.assertEquals(responseCode, response.getStatusCode());
	}

	@Then("^it should display the sub-categories List$")
	public void it_should_display_the_sub_categories_List(DataTable table) throws Throwable {
		categoryList = new ArrayList<String>();
		for (DataTableRow tab : table.getGherkinRows())
			categoryList.add(tab.getCells().get(0));
		JsonPath js = response.jsonPath();
		String subcategories = js.getString("name");
		Assert.assertTrue(categoryList.contains(subcategories));

	}

	// feature 2
	/*@When("^made request products for the categories  (\\d+)$")
	public void made_request_products_for_the_categories(int categoryID) throws Throwable {
		url = url + "category/" + categoryID + "/product";
		response = given().when().get(url);
	}

	@Then("^it should display the products List$")
	public void it_should_display_the_products_List(DataTable table) throws Throwable {
		productList = new ArrayList<String>();
		for (DataTableRow tab : table.getGherkinRows())
			productList.add(tab.getCells().get(0));
		JsonPath js = response.jsonPath();
		String products = js.getString("name");
		Assert.assertTrue(productList.contains(products));
	}*/

	// feature 3
	/*@When("^made request for the user orders  (\\d+)$")
	public void made_request_for_the_user_orders(int userID) throws Throwable {
		url = url + "user/" + userID + "/orders";

		response = given().when().get(url);

	}

	@Then("^it should display the order List$")
	public void it_should_display_the_order_List(DataTable table) throws Throwable {
		orderList = new ArrayList<String>();
		for (DataTableRow tab : table.getGherkinRows())
			orderList.add(tab.getCells().get(0));
		JsonPath js = response.jsonPath();

		String orderedProducts = js.getString("userOrderItemModelList.product.name");

		Assert.assertTrue(orderList.contains(orderedProducts));

	}*/

	// feature 4

	/*@When("^made post request  for the products  (\\d+)$")
	public void made_post_request_for_the_products(int userID, DataTable table) throws Throwable {
		url = url + "user/" + userID + "/orders";
		cartItemId = new HashMap<String, Integer>();
		for (DataTableRow tab : table.getGherkinRows())
			cartItemId.put(tab.getCells().get(0), Integer.parseInt(tab.getCells().get(1)));
		System.out.println(cartItemId);
		response = given().contentType(ContentType.JSON).body(cartItemId).when().post(url);
		System.out.println(response);

	}

	@Then("^order should be added to the user$")
	public void order_should_be_added_to_the_user() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");

		Assert.assertEquals("Success", status);

	}*/
	// feature 5

	/*@When("^choose the product , quantity and made a post request for user (\\d+)$")
	public void choose_the_product_quantity_and_made_a_post_request_for_user(int userID, DataTable table)
			throws Throwable {
		url = url + "user/" + userID + "/cart";
		cart = new HashMap<String, Integer>();
		for (DataTableRow tab : table.getGherkinRows())
			cart.put(tab.getCells().get(0), Integer.parseInt(tab.getCells().get(1)));
		System.out.println(cart);
		response = given().contentType(ContentType.JSON).body(cart).when().post(url);

	}

	@Then("^product should be added to cart$")
	public void product_should_be_added_to_cart() throws Throwable {

		JsonPath js = response.jsonPath();

		int productId = Integer.parseInt(js.getString("responseObject.productId"));
		System.out.println(productId);
		Assert.assertTrue(cart.containsValue(productId));

	}*/
	// updation of cart quantity

	/*@When("^made a post request for user (\\d+) and update quantity (\\d+) for the cart (\\d+)$")
	public void made_a_post_request_for_user_and_update_quantity_for_the_cart(int userId, int quantity, int cartItemId)
			throws Throwable {
		url = url + "user/" + userId + "/cart/" + cartItemId;
		System.out.println(url);
		cartQuantityUpdate = new HashMap<String, Integer>();
		cartQuantityUpdate.put("cartItemId", cartItemId);
		cartQuantityUpdate.put("quantity", quantity);

		response = given().contentType(ContentType.JSON).body(cartQuantityUpdate).when().put(url);
	}

	@Then("^cart product quantity should be updated$")
	public void cart_product_quantity_should_be_updated() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");

		Assert.assertEquals("Success", status);
	}*/

	// updation of cart q uantity to neagtive
	/*@When("^made  post request for user (\\d+) and update quantity -(\\d+) for the cart (\\d+)$")
	public void made_post_request_for_user_and_update_quantity_for_the_cart(int userId, int quantity, int cartItemId)
			throws Throwable {
		url = url + "user/" + userId + "/cart/" + cartItemId;
		System.out.println(url);
		cartQuantityUpdate = new HashMap<String, Integer>();
		cartQuantityUpdate.put("cartItemId", cartItemId);
		cartQuantityUpdate.put("quantity", -quantity);
		response = given().contentType(ContentType.JSON).body(cartQuantityUpdate).when().put(url);
	}

	@Then("^should show warning message$")
	public void should_show_warning_message() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");
		Assert.assertEquals("InvalidQuantity", status);
	}*/

	// delete product from cart

	/*@When("^made a delete request for users (\\d+)  cart (\\d+)$")
	public void made_a_delete_request_for_users_cart(int userID, int cartItemId) throws Throwable {
		cartId = cartItemId;
		url = url + "user/" + userID + "/cart/" + cartItemId;
		response = given().when().delete(url);

	}

	@Then("^product should be removed from cart$")
	public void product_should_be_removed_from_cart() throws Throwable {
		JsonPath js = response.jsonPath();

		int cartID = Integer.parseInt(js.getString("cartItemId"));
		Assert.assertEquals(cartId, cartID);
	}*/

	// checkout

	/*@When("^made a delete request for users (\\d+)  cart$")
	public void made_a_delete_request_for_users_cart(int userID) throws Throwable {
		url = url + "user/" + userID + "/orders/all";
		response = given().when().post(url);
	}

	@Then("^all the products should be placed$")
	public void all_the_products_should_be_placed() throws Throwable {
		String isCheckedOut = response.getBody().asString();
		System.out.println(isCheckedOut);
		Assert.assertEquals("true", isCheckedOut);
	}*/

	// fetching cart products

	/*@When("^made a get request for the cart products for user (\\d+)$")
	public void made_a_get_request_for_the_cart_products_for_user(int userID) throws Throwable {
		url = url + "user/" + userID + "/cart";
		response = given().when().get(url);

	}

	@Then("^all products should be fetched$")
	public void all_products_should_be_fetched() throws Throwable {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}*/

}
