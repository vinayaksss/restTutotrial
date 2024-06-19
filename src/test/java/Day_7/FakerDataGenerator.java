package Day_7;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class FakerDataGenerator {
	
	@Test
	void generator() {
		
		Faker fk=new Faker();
		System.out.println(fk.name().firstName());
		
		
		
		
	}

}
