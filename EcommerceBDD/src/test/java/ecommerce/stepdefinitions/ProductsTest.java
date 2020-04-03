package ecommerce.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductsTest {
	Response response;
	List<String> categoryList;
	List<String> productList;
	List<String> orderList;
	Map<String, Integer> cartItemId;
	Map<String, Integer> cart;
	Map<String, Integer> cartQuantityUpdate;
	Map<String, Integer> removalFromCart;
	int cartId;

	@When("^made request products for the categories  (\\d+)$")
	public void made_request_products_for_the_categories(int categoryID) throws Throwable {
		String url=Utils.getUrl();
		url = url + "category/" + categoryID + "/product";
		response = given().when().get(url);
		Utils.setResponse(response);
	}

	@Then("^it should display the products List$")
	public void it_should_display_the_products_List(DataTable table) throws Throwable {
		productList = new ArrayList<String>();
		for (DataTableRow tab : table.getGherkinRows())
			productList.add(tab.getCells().get(0));
		JsonPath js = response.jsonPath();
		String products = js.getString("name");
		Assert.assertTrue(productList.contains(products));
	}
	@When("^made a delete request for users (\\d+)  cart (\\d+)$")
	public void made_a_delete_request_for_users_cart(int userID, int cartItemId) throws Throwable {
		cartId = cartItemId;
		String url=Utils.getUrl();
		url = url + "user/" + userID + "/cart/" + cartItemId;
		response = given().when().delete(url);
		Utils.setResponse(response);

	}

	@Then("^product should be removed from cart$")
	public void product_should_be_removed_from_cart() throws Throwable {
		JsonPath js = response.jsonPath();

		int cartID = Integer.parseInt(js.getString("cartItemId"));
		Assert.assertEquals(cartId, cartID);
	}
}
