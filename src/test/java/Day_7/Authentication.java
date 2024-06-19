package Day_7;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class Authentication {
	
	@Test
	void basicAuth() {
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.log().body();
	}
	
	@Test
	void digestAuth() {
		
		given()
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/digest-auth")
		.then()
		.statusCode(200)
		.log().body();
	}

	
	@Test
	void bearTokenAuth() {
		String bearerToken="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";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().body();
	}
	
	@Test
	void oauth1() {
		//String bearerToken="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";
		given()
		.auth().oauth("ConsumerKey", "ConsumerSecrat", "accessToken","tokensecrat")
		
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().body();
	}
	
	@Test
	void oauth2() {
		//String bearerToken="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";
		given()
		.auth().oauth2("")
		
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().body();
	}
	
	@Test
	void apiKeyAuth() {
		
		given()
		.queryParam("appid", "key")
		
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().body();
	}
}
