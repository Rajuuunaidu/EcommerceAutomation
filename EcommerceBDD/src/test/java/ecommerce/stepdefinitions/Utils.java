package ecommerce.stepdefinitions;

import io.restassured.response.Response;

public class Utils {
	static String url;
	static Response response;
	public static void setUrl(String URL) {
		 url=URL;
	}
public static String getUrl() {
	return url;
}
public static Response getResponse() {
	return response;
}
public static  void setResponse(Response res) {
	response = res;
}

}
