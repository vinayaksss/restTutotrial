package Day_8;


import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class CreateUserChaining {
	
	static int id;
	
	
	@Test
	void createUser() {
		Faker fk=new Faker();
		TestData td= new TestData();
		td.setName("test");
		td.setEmail(fk.internet().emailAddress());
		td.setGender("Male");
		td.setStatus("Active");
				
		String token="9ad219c75f5a1f2388d152e1f7a132b98b028b8012f5adc6e679d3401b290aaf";
		Response res=given()
		
		.headers("Authorization", "Bearer "+token)
		.contentType("application/json")
		.body(td)
				
		.when()
		.post("https://gorest.co.in/public/v2/users");
		id=res.body().jsonPath().getInt("id");
		System.out.println("User Id is "+id);
		td.setId(id);
		System.out.println(td.getId());
		
	}
	
	

	

}
