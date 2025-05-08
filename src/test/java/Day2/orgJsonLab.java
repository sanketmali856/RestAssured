package Day2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class orgJsonLab {
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
	void postRequestOrgJsonLab() {	
	
		JSONObject data = new JSONObject();
		data.put("name", "cool");
        data.put("job", "develper");
	 
      Response res = 
       requs
	 	.body(data.toString())
	   .when()
	 	.post("https://reqres.in/api/users");
	 	
	 	
     res.then()
	 	 .statusCode(201)
	 	 .body("name",equalTo("cool"))
	 	 .log().all();
     
     id = res.jsonPath().getInt("id");
     System.out.println(id+" == this is id ");
	}
	

	
	void deletRequest() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		
		.then()
			.statusCode(204);
	}

}
