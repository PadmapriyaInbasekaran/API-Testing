import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class cookie {

    @Test
    public void restAssuredWithCookies() {
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","AUEFqZdrYOgRaTNmiclmAuE80HQEPdJ-Fl6EIc9ZCrcclzFOqI7Sb8C9YQ")
                .log().all();
    }
    @Test
    public void restAssuredWithAllCookies() {
       Response res = given()
                .when()
                .get("https://www.google.com/");
        Map<String, String> getAllCookies = res.getCookies();
        for(String s : getAllCookies.keySet()) {
            String cookie = res.getCookie(s);
            System.out.println(cookie);
        }
    }
}
