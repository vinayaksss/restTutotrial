package Day_3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Headers {
	
@Test
	
	void getHeaders() {
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding","gzip");
		
	}

@Test

void validateHeaders() {
	Response res=given()	.when()
	.get("https://www.google.com");
	String singleHeader=res.getHeader("Content-Type");
	System.out.println("singleHeader  "+singleHeader);
	System.out.println("singleHeader  "+res.getHeader("Content-Encoding"));
	System.out.println("getAllHeaders "+res.getHeaders());
		res.then();
	
	
	
}

}
