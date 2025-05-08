package Day2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class externalJsonData {
	RequestSpecification requs;
	int id;
	
	@BeforeClass
	void authintcation() {
		RestAssured.baseURI="https://reqres.in";
		requs= given()
				.header("x-api-key", "reqres-free-v1")
				.header("content-Type","application/json");
	}
	
	@Test
	void postRequestDataFromExternalJSON() throws FileNotFoundException {	
	
		File fl = new File("C:\\Users\\Shubham Shetti\\eclipse-workspace\\Automation\\src\\test\\resources\\data.json");
		FileReader fr = new FileReader(fl);
		JSONTokener tr = new JSONTokener(fr);
		JSONObject data = new JSONObject(tr);
	 
      Response res = 
       requs
	 	.body(data.toString())
	   .when()
	 	.post("https://reqres.in/api/users");
	 	
	 	
     res.then()
	 	 .statusCode(201)
	 	 .body("name",equalTo("sanket"))
	 	 .log().all();
     
     id = res.jsonPath().getInt("id");
     System.out.println(id+"= this is id ");
	}
	
	void deletRequest() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		
		.then()
			.statusCode(204);
	}

}
