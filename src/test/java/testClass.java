import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testClass {

    @Test
    void test2() throws ParseException {
        Response response = given().when().header("Authorization", "hagar.abdelwahab@gmail.com")
                .get("https://case-api.trella.app/marketplace?lng=30&lat=30").then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println(response.asPrettyString());
        ResponseValidations.validateResponse(response, 3);
    }

    @Test
    void test1() throws ParseException {
        Response response = given().when().header("Authorization", "hagar.abdelwahab@gmail.com")
                .get("https://case-api.trella.app/marketplace").then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println(response.asPrettyString());
        ResponseValidations.validateResponse(response, 7);
    }
}
