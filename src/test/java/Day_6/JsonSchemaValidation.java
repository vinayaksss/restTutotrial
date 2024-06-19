package Day_6;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
public class JsonSchemaValidation {
	
	@Test
	void jsonSchemavalidation() {
		
		
		given()
		
		.when()
		.get("https://fakestoreapi.com/products/1")
		.then()
		
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json.json"))
		
		//if xml response 
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("path"));

	}

}
