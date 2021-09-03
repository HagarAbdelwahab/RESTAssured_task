package marketPlaceEndPoint;

import io.restassured.response.Response;
import marketPlace.ResponseValidations;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static util.datareaders.PropertiesReader.readFileTestResources;

public class testClass {

    @Test
    void testMarketPlaceEndpointToReturnAllShipments() throws ParseException {
        Response response = given().when().header("Authorization", readFileTestResources("AuthorizationHeader")).
                get(readFileTestResources("URL")).then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        ResponseValidations.validateResponseStructure(response);
        ResponseValidations.CheckNumberOfShipmentsReturned(response, 7);
        ResponseValidations.validateResponseFields(response);
    }

    @Test
    void testMarketPlaceEndpointForSpecificLocation() throws ParseException {
        Response response = given().when().header("Authorization", readFileTestResources("AuthorizationHeader")).
                queryParam("lng", 30)
                .queryParam("lat", 30)
                .get(readFileTestResources("URL")).then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println(response.asPrettyString());
        ResponseValidations.validateResponseStructure(response);
        ResponseValidations.CheckNumberOfShipmentsReturned(response, 3);
        ResponseValidations.validateResponseFields(response);
    }
}
