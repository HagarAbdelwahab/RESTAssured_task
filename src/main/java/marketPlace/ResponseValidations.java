package marketPlace;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class ResponseValidations {
    private static JSONParser parser = new JSONParser();
    private static final SoftAssert softAssertion = new SoftAssert();

    /*
     *This method is to validate the response structure that it contains all the necessary fields
     * @param response: service response
     */
    public static void validateResponseStructure(Response response) throws ParseException {
        String responseBody = response.getBody().asString();
        ArrayList<JSONObject> shipmentsArray = (ArrayList<JSONObject>) parser.parse(responseBody);
        for (JSONObject shipment : shipmentsArray) {
            softAssertion.assertNotNull(shipment.get("key"));
            softAssertion.assertNotNull(shipment.get("numberOfBids"));
            softAssertion.assertNotNull(shipment.get("commodity"));
            softAssertion.assertNotNull(shipment.get("vehicleType"));
            softAssertion.assertNotNull(shipment.get("price"));
            softAssertion.assertNotNull(shipment.get("addresses"));
            ArrayList<JSONObject> addressArray = (ArrayList<JSONObject>) shipment.get("addresses");
            for (JSONObject address : addressArray) {
                softAssertion.assertNotNull(address.get("order"));
                softAssertion.assertNotNull(address.get("key"));
                softAssertion.assertNotNull(address.get("latitude"));
                softAssertion.assertNotNull(address.get("longitude"));
                softAssertion.assertNotNull(address.get("name"));
            }
        }
        softAssertion.assertAll();
    }

    /*
     *This method is to validate that all response fields have values
     * @param response: service response
     */
    public static void validateResponseFields(Response response) throws ParseException {
        String responseBody = response.getBody().asString();
        ArrayList<JSONObject> shipmentsArray = (ArrayList<JSONObject>) parser.parse(responseBody);
        for (JSONObject shipment : shipmentsArray) {
            softAssertion.assertTrue(shipment.containsKey("key"));
            softAssertion.assertTrue(shipment.containsKey("numberOfBids"));
            softAssertion.assertTrue(shipment.containsKey("commodity"));
            softAssertion.assertTrue(shipment.containsKey("vehicleType"));
            softAssertion.assertTrue(shipment.containsKey("price"));
            softAssertion.assertTrue(shipment.containsKey("addresses"));
            ArrayList<JSONObject> addressArray = (ArrayList<JSONObject>) shipment.get("addresses");
            for (JSONObject address : addressArray) {
                softAssertion.assertTrue(address.containsKey("order"));
                softAssertion.assertTrue(address.containsKey("key"));
                softAssertion.assertTrue(address.containsKey("latitude"));
                softAssertion.assertTrue(address.containsKey("longitude"));
                softAssertion.assertTrue(address.containsKey("name"));
            }
        }
        softAssertion.assertAll();
    }

    /*
     *This method is to validate the response has the expected number of shipments
     * @param response: service response
     * @param numberOfShipments: number of shipments returned from api
     */
    public static void CheckNumberOfShipmentsReturned(Response response, int numberOfShipments) throws ParseException {
        String responseBody = response.getBody().asString();
        ArrayList<JSONObject> shipmentsArray = (ArrayList<JSONObject>) parser.parse(responseBody);
        softAssertion.assertEquals(shipmentsArray.size(), numberOfShipments);

    }

}



