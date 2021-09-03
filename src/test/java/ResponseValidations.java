
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;

public class ResponseValidations {
    private static JSONParser parser = new JSONParser();
    private static final SoftAssert softAssertion = new SoftAssert();

    public static void validateResponse(Response response, int numberOfShipments) throws ParseException {
        String responseBody = response.getBody().asString();
        parser = new JSONParser();
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
                String shipmentName = (String) address.get("name");
                System.out.println(shipmentName);
            }
            System.out.println(shipmentsArray.size());
            softAssertion.assertEquals(shipmentsArray.size(), numberOfShipments);
        }
        softAssertion.assertAll();
    }

}



