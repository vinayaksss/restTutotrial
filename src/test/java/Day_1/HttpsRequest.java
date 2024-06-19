package Day_1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpsRequest {
	
	  @Test
	  
	  void getProduct() {
	  
	  given()
	  
	  .when().get("https://fakestoreapi.com/products/1")
	  
	  .then().log().body(); 
	  
	  }
	 
	@Test
	void createProduct() {
		HashMap hm= new HashMap();
		hm.put ("title","testVinayak1");
		hm.put ("price",13.5);
		hm.put ("description", "lorem ipsum set1");
		hm.put ("image", "https://i.pravatar.cc1");
		hm.put ("category", "electronic1");
		
		int id=given()
		
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://fakestoreapi.com/products")
		.jsonPath().getInt("id");
		//.then()
	//.log().body();
}
	
	
	@Test
	void updateProduct() {
		HashMap hm= new HashMap();
		hm.put ("title","testSonar");
		hm.put ("price",13.5);
		hm.put ("description", "lorem ipsum set1");
		hm.put ("image", "https://i.pravatar.cc1");
		hm.put ("category", "electronic1");
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://fakestoreapi.com/products")
		.then()
	.log().body();
}
	
	@Test
	void deleteProduct() {
		when()
		.post("https://fakestoreapi.com/products/6")
		.then()
	.log().body();
}
}
