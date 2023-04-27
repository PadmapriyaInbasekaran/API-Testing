import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestNGAssertion {

    @Test
    public void restAssuredWithLog() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.getContentType(), "text/html; charset=ISO-8859-1");
        Assert.assertEquals(res.jsonPath().get("book[3].title").toString(),"xyz");
    }
}
