import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqBodyWithJsonObject {
    @Test
    public void restAssuredReqBody()
    {
//add json.org dependency in pom.xml
        JSONObject data = new JSONObject();
        data.put("name", "xyz");
        data.put("job", "pqr");
        String[] course = {"english", "maths"};
        data.put("courses", course);
        given()
                .contentType("application/json")
                .body(data.toString())//when we r using JSONObject, we need to send body as string.
                //This string will be converted to JSON.

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201).
                body("name",equalTo("xyz")).
                body("job",equalTo("pqr")).
                header("Content-Type","application/json; charset=utf-8").
                log().all();
    }
}
