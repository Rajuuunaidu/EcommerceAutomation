package ecommerce.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OrdersTest {
	Response response;
	List<String> categoryList;
	List<String> productList;
	List<String> orderList;
	Map<String, Integer> cartItemId;
	Map<String, Integer> cart;
	Map<String, Integer> cartQuantityUpdate;
	Map<String, Integer> removalFromCart;
	int cartId;
	
	@When("^made request for the user orders  (\\d+)$")
	public void made_request_for_the_user_orders(int userID) throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/orders";

		response = given().when().get(url);
		Utils.setResponse(response);

	}

	@Then("^it should display the order List$")
	public void it_should_display_the_order_List(DataTable table) throws Throwable {
		orderList = new ArrayList<String>();
		for (DataTableRow tab : table.getGherkinRows())
			orderList.add(tab.getCells().get(0));
		JsonPath js = response.jsonPath();

		String orderedProducts = js.getString("userOrderItemModelList.product.name");

		Assert.assertTrue(orderList.contains(orderedProducts));

	}
	@When("^made post request  for the products  (\\d+)$")
	public void made_post_request_for_the_products(int userID, DataTable table) throws Throwable {
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/orders";
		cartItemId = new HashMap<String, Integer>();
		for (DataTableRow tab : table.getGherkinRows())
			cartItemId.put(tab.getCells().get(0), Integer.parseInt(tab.getCells().get(1)));
		System.out.println(cartItemId);
		response = given().contentType(ContentType.JSON).body(cartItemId).when().post(url);
		Utils.setResponse(response);
		System.out.println(response);

	}

	@Then("^order should be added to the user$")
	public void order_should_be_added_to_the_user() throws Throwable {
		JsonPath js = response.jsonPath();

		String status = js.getString("status");

		Assert.assertEquals("Success", status);

	}

}
