import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqBodyWithExternalFile {


    @Test
    public void restAssuredReqBody() throws FileNotFoundException {
        File f = new File(".\\info.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(jo.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201).
                body("name",equalTo("xyz")).
                body("location",equalTo("pqr")).
                header("Content-Type","application/json; charset=utf-8").
                log().all();
    }

}
