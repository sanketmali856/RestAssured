package Day2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HasMapData {
	RequestSpecification requs;
	
	@BeforeClass
	void authintcation() {
		RestAssured.baseURI="https://reqres.in";
		requs= given()
				.header("x-api-key", "reqres-free-v1")
				.header("content-Type","application/json");
	}
	
	@Test
	void cretaRequest() {	
	Map<String, String> data = new HashMap<String, String>();
	
	 data.put("name","sanket");
	 data.put("job","leader");
	 
	 requs
	 	.body(data)
	 .when()
	 	.post("https://reqres.in/api/users")
	 .then()
	 	.statusCode(201)
	 	.body("name",equalTo("sanket"))
	 	.log().all();
	 	
	}

}
