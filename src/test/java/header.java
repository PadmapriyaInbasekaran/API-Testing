import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class header {

    @Test
    public void restAssuredWithHeaders() {
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .log().all();
    }
    @Test
    public void restAssuredWithAllHeaders() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
        Headers getAllHeaders = res.getHeaders();
        for(Header s : getAllHeaders) {
            System.out.println(s);
        }
    }
}
