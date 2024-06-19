package Day_5;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
///C:\Users\svinayak\Downloads>java -jar file-upload-RestAPI.jar (Run this jar to upload)
public class UploadAndDownload {
	
	  @Test void uploadFile() { File myfile= new
	  File("C:\\Users\\svinayak\\Desktop\\text.txt");
	  
	  given() .multiPart("file",myfile) .contentType("multipart/form-data") .when()
	  
	  .post("http://localhost:8080/uploadFile") .then() .statusCode(200)
	  .log().body();
	  
	  }
	 
	/*
	 * @Test void multipleUploadFile() { File myfile= new
	 * File("C:\\Users\\svinayak\\Desktop\\text.txt"); File myfile1= new
	 * File("C:\\Users\\svinayak\\Desktop\\text1.txt"); File filearr[]=
	 * {myfile1,myfile}; given() .multiPart("file",filearr)
	 * //.multiPart("file",myfile1) .contentType("multipart/form-data") .when()
	 * 
	 * .post("http://localhost:8080/uploadMultipleFiles") .then() .statusCode(200)
	 * .log().all();
	 * 
	 * }
	 */
	@Test 
	void fileDownload()
	{
		given()
		
		.when()
			.get("http://localhost:8080/downloadFile/text.txt")
		.then()
			.statusCode(200)
			.log().body();	
		}


}
