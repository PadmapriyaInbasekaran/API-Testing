import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqBodyWithPOJOClass {

    @Test
    public void restAssuredReqBody()
    {
        Pojo_class pojoclass = new Pojo_class();
        pojoclass.setName("xyz");
        pojoclass.setLocation("abc");
        pojoclass.setPhone("123");
        String courses[] = {"xyz","abc"};
        pojoclass.setCourses(courses);
        given()
                .contentType("application/json")
                .body(pojoclass)

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201).
                body("name",equalTo("xyz")).
                body("location",equalTo("abc")).
                header("Content-Type","application/json; charset=utf-8").
                log().all();
    }

}
