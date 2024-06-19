package Day_2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class DiffWaysOfPayLoad {
	
	
	
	@Test
	void usingHashmap() {
		
		HashMap hm= new HashMap();
		hm.put ("title","testVinayak1");
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
	void usingJsonObject() {
		
		JSONObject hm= new JSONObject();
		hm.put ("title","JSon");
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
	.statusCode(200)
	//.body("title",equalTo("JSon"))
.log().all();
		
	
		
		
	}
	
	@Test
	
	void usingPojoclass() {
		
		PojoClass pojo= new PojoClass();
		pojo.setTitle("PojoClass");
		pojo.setPrice(12);
		pojo.setDescription("Pojoclass");
		pojo.setImage("https://i.pravatar.cc1");
		pojo.setCategory("electronic1");
		
		
		given()
		.contentType("application/json")
		.body(pojo)
		.when()
		.post("https://fakestoreapi.com/products")
		.then()
		.statusCode(200)
		.body("title",equalTo("PojoClass"))
		.log().body();
				
		
		
	}
	
	
	/*
	 * @Test void usingExternalFile() {
	 * 
	 * File f= new File(".\\body.json"); try { FileReader fr= new FileReader();
	 * JSONTokener js= new JSONTokener(fr); JSONObject data= JSONObject(js);
	 * 
	 * } catch(IOException e){s e.printStackTrace(); } given()
	 * .contentType("application/json") .body(data.toString()) .when()
	 * .post("https://fakestoreapi.com/products") .then() .statusCode(200)
	 * .body("title",equalTo("PojoClass")) .log().body();
	 * 
	 * }
	 */
	 
}
