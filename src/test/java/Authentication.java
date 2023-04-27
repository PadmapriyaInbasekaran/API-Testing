import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Authentication {

    @Test
    public void restAssuredBasicAuth() {
        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .body("authenticated",equalTo("true"));
    }
    @Test
    public void restAssuredPreemptive() {
        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .body("authenticated",equalTo("true"));
    }
    @Test
    public void restAssuredDigest() {
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .body("authenticated",equalTo("true"));
    }

    @Test
    public void restAssuredBearerToken() {
        given()
                .headers("Authorization","Bearer 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")
                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200);
    }

    @Test
    public void restAssuredOauth1() {
        given()
                .auth().oauth("ConsumerKey","ConsumerSecret","AccessToken","TokenSecret")
                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200);
    }

    @Test
    public void restAssuredOauth2() {
        given()
                .auth().oauth2("Token")
                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200);
    }

    @Test
    public void restAssuredApiKey() {
        given()
                .queryParam("Key","Value")
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200);
    }

}
