package marketPlaceEndPoint;
import io.restassured.response.Response;
import marketPlace.ResponseValidations;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class testClass {

    @Test
    void testMarketPlaceEndpointToReturnAllShipments() throws ParseException {
        Response response = given().when().header("Authorization", "hagar.abdelwahab@gmail.com")
                .get("https://case-api.trella.app/marketplace").then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        ResponseValidations.validateResponseStructure(response);
        ResponseValidations.CheckNumberOfShipmentsReturned(response, 7);
        ResponseValidations.validateResponseFields(response);
    }

    @Test
    void testMarketPlaceEndpointForSpecificLocation() throws ParseException {
        Response response = given().when().header("Authorization", "hagar.abdelwahab@gmail.com")
                .get("https://case-api.trella.app/marketplace?lng=30&lat=30").then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        ResponseValidations.validateResponseStructure(response);
        ResponseValidations.CheckNumberOfShipmentsReturned(response, 3);
        ResponseValidations.validateResponseFields(response);
    }
}
