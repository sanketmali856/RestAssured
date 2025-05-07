package Request;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpRequest {

    int Id;
    RequestSpecification requestSpec;

    @BeforeClass
    void setup() {
        RestAssured.baseURI = "https://reqres.in";

        requestSpec = given()
            .header("x-api-key", "reqres-free-v1") // ✅ API key added
            .header("Content-Type", "application/json");
    }

    @Test(priority = 0)
    void getUser() {
        requestSpec
            .when()
                .get("/api/users?page=2")
            .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 1)
    void createUser() {

        Map<String, String> data = new HashMap<>();
        data.put("name", "sanket");
        data.put("job", "tester");

        Response res = requestSpec
            .body(data)
            .when()
                .post("/api/users");

        res.then()
            .statusCode(201)
            .body("name", equalTo("sanket"))
            .body("job", equalTo("tester"))
            .log().all();

        Id = res.jsonPath().getInt("id");  // ✅ Get ID from response
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUser() {

        Map<String, String> data = new HashMap<>();
        data.put("name", "johan");
        data.put("job", "devloper");

        requestSpec
            .body(data)
            .when()
                .put("/api/users/" + Id)
            .then()
                .statusCode(200)
                .body("name", equalTo("johan"))
                .body("job", equalTo("devloper"))
                .log().all();
    }
}
 