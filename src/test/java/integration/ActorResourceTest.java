package integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class ActorResourceTest {
    @Test
    public void itAddsActor() {
        given()
                .port(8180)
                .header("Content-Type", "application/json")
                .body("{\"name\": \"George Clooney\", \"yearOfBirth\": 1961}")
        .when()
                .post("/jazzad5/v1/actors")
        .then()
                .statusCode(200)
                .body("name", equalTo("George Clooney"))
                .body("yearOfBirth", equalTo(1961));
    }
}
