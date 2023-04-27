import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class RestAssured {
    int id;

    @Test
    public void restAssuredGetRequest() {
        given()
                .pathParam("users","users")
                .queryParam("page",2)
                .when()
                    .get("https://reqres.in/api/{users}")

                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test(priority = 1)
    public void restAssuredPostRequest() {

        HashMap data = new HashMap();
        data.put("name", "xyz");
        data.put("job", "pqr");

        id = given()
                .contentType("application/json")
                .body(data)

                    .when()
                        .post("https://reqres.in/api/users")
                        .jsonPath().getInt("id");
    }

    @Test(priority = 2)
    public void restAssuredPutRequest() {

        HashMap data = new HashMap();
        data.put("name", "xyz");
        data.put("job", "teacher");

        given()

                .when()
                    .put("https://reqres.in/api/users/" + id)

                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test(priority = 3)
    public void restAssuredDeleteRequest() {

        given()

                .when()
                    .delete("https://reqres.in/api/users/" + id)

                .then()
                    .statusCode(204)
                    .log().all();
    }

}
