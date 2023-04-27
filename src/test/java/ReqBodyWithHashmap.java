import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqBodyWithHashmap {
    @Test
    public void restAssuredReqBody()
    {

        HashMap data = new HashMap();
        data.put("name", "xyz");
        data.put("job", "pqr");
        String[] course = {"english", "maths"};
        data.put("courses", course);
        given()
                .contentType("application/json")
                .body(data)

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
