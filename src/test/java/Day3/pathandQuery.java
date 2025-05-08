package Day3;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class pathandQuery {
	RequestSpecification requs;
	int id;
	
	@BeforeClass
	void authintcation() {
		RestAssured.baseURI="https://reqres.in";
		requs= given()
				.pathParam("myPath1","api")
				.pathParam("myPath2","users")
				.queryParam("page", 2)//this no need to mention in the url it will take autmatically actula path is ="https://reqres.in/api/users?page=2"
				//.queryParam("id", 3)
				.header("x-api-key", "reqres-free-v1")
				.header("content-Type","application/json");
				
	}
	
	@Test
	void postRequestOrgJsonLab() {	
		
	 
      Response res = 
       requs
	   .when()
	 	.get("https://reqres.in/{myPath1}/{myPath2}");
	 	
	 	
     res.then()
	 	 .statusCode(200)
	 	 .log().all();
	}
	

	


}
