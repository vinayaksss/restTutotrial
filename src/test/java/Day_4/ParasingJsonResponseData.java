package Day_4;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

public class ParasingJsonResponseData {
	
	
	
	@Test
	void testJsonResponse() {
	/*
	 * Response res= given()
	 * 
	 * .when().get("https://fakestoreapi.com/products/1"); String
	 * tittle=res.jsonPath().getString("title");
	 * System.out.println(" To Test res "+tittle); //Approach 1
	 * Assert.assertEquals(res.getStatusCode(),200);
	 * Assert.assertEquals(res.jsonPath().getString("title"),
	 * "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
	 * Assert.assertEquals(res.jsonPath().getInt("rating.count"), 120);
	 *  
	 * res .then() .statusCode(200) .header("Content-Type",
	 * "application/json; charset=utf-8") //Approach 2
	 * .body("rating.count",equalTo(120))
	 * .body("title",equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
	 * )) .log().body();
	 * 
	 * }
	 */
	}	
	
	@Test
	void testJsonResponse_2() {
	
		 Response res = given()
			        .when().get("https://fakestoreapi.com/products");

			    // Convert response body to a string and then to a JSONArray
			    String responseBody = res.getBody().asString();
			    JSONArray jsonArray = new JSONArray(responseBody);
			    boolean status=false;
			    // Iterate through the array and print the titles
			    for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject product = jsonArray.getJSONObject(i);
			        String title = product.getString("title");
			        System.out.println("Title: " + title);
			        
			        if(title.equals("Mens Cotton Jacket")){
			        	status=true;
			        	break;
			        }
			    }
			    Assert.assertEquals(status, true);
			}
	
	
	}
		
		
	


