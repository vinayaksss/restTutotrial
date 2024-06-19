package Day_3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap; 

public class PathAndQueryParameter {

	
	@Test
	void pathQueryParameter() {
		//https://reqres.in/api/users?page=2&id=2
		//https://gorest.co.in/public/v2/users/2934647
		int userID=1;
		given()
		.pathParam("mypath", userID)
		//.queryParam("id",5)
		.when()
		.get("https://fakestoreapi.com/products/{mypath}")
		.then()
		
		.log().body();
	
	}
}
