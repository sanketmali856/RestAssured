package Day3;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class headers {
	
	@Test(priority=0)
	public void testHader() {
		given()
		
		.when()
			.get("https://www.google.co.in/")
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Server", "gws");	
	}
	
	@Test(priority=1)
	public void testHaders() {
		Response res =given()
		
		.when()
			.get("https://www.google.co.in/");
		res.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Server", "gws")
			.log().headers();  // this one approce to print all herders 
		
		Headers hd =res.headers();
			
		for(Header k:hd) {
			System.out.println(k.getName()+":"+k.getValue());
		}
		
	}
	
	
	

}
