package Day_3;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

public class CookiesAndHeaders {
	
	
	@Test
	void cokkiesAndHeaders() {
		
	Response res=given()
		.when()
		.get("https://www.google.com");
		String cookie_value=res.getCookie("AEC");
		Map<String ,String>cokie=res.getCookies();
		//System.out.println("Cookie Value "+cookie_value);
		System.out.println("All Cookie Value "+cokie.keySet());
		
		for(String cook:cokie.keySet()) {
		String ccok_value=res.getCookie(cook);
			//System.out.println("For Loop "+ccok_value);
			System.out.println(cook+"-"+" -"+ccok_value);
		}
		res.then()
		.statusCode(200);
	}
	
	@Test
	
	void getCookieInfo() {
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.cookie("AEC");
			//.log().cookies();
		
	}

}
