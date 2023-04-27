import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class log {

    @Test
    public void restAssuredWithLog() {
        given()
                .when()
                .get("https://www.google.com/")

                .then()
               // .log().body();       //logs the body content
               // .log().all();        //logs all the content
                .log().headers();      //logs all the header content
    }
}
