package Day3;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookies {
	
	@Test
	void getCookies() {
		
		
		Response res= when()
			.get("https://www.google.co.in/");
		
		//String value = res.getCookie("AEC");
		//System.out.println(value);
		//Print the all cookies with its value 
		Map<String , String> values = res.getCookies();
		for(String k :values.keySet()) {
			String v= res.getCookie(k);
			
			System.out.println(k+":"+v);
		}
	}

}
