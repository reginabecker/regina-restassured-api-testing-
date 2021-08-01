package br.com.restassuredapitesting.utils;
import org.json.simple.JSONObject;

public class Utils {

    public static JSONObject validPayloadBooking() {
        JSONObject payload = new JSONObject();

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-04-07");
        bookingDates.put("checkout", "2021-06-08");

        payload.put("firstname", "Jim");
        payload.put("lastname", "Brown");
        payload.put("totalprice", 707);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "Breakfast");

        return payload;
    }

    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }
    
    public static JSONObject validPayloadMalFormatadoBooking() {
        JSONObject payloadBad = new JSONObject();

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2016-05-31");

        payloadBad.put("firstname", "Jim");
        payloadBad.put("lastname", "Brown");
        payloadBad.put("totalprice", 465);
        payloadBad.put("depositpaid", false);
        payloadBad.put("bookingdates", bookingDates);
        payloadBad.put("additionalneeds", "Breakfast");

        return payloadBad;
    }
}
