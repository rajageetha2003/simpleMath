package apiServices;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.response.Response;

public class RequestAPI {

    private static final String BASEURL = "http://localhost:8080/simpleMath_war_exploded";
    public static String apiUrl;
    public static Response response;
    public static String jsonAsString;

    public void callAddNumbers(String val1, String val2){
        apiUrl = BASEURL + "/add/"+ val1 + "/"+val2;
    }

    public void assertResponse(String result){
        response =    given().when().post(apiUrl).then().statusCode(200).and().extract().response(); // extract the response
        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        jsonAsString = response.asString();
        System.out.println(jsonAsString + ":"+ result);
        assert(jsonAsString.equals(result));
    }

    public void assertStatusCode(int StatucCode){
        given().when().post(apiUrl)
                .then().statusCode(StatucCode);
    }

}
