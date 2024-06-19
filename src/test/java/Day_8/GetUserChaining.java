package Day_8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class GetUserChaining {
	
	@Test
	void getUser() {
		
		
		System.out.println("Chanigg id "+CreateUserChaining.id);
		String token="9ad219c75f5a1f2388d152e1f7a132b98b028b8012f5adc6e679d3401b290aaf";
		given()
		.headers("Authorization", "Bearer "+token)
		.contentType("application/json")
		.when()
		.get("https://gorest.co.in/public/v2/users/"+CreateUserChaining.id)
		.then()
		.log().body();
		
		
	}

}
