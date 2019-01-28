package generalmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

import java.util.List;

public class GetRequest {

    TestEnvironment testEnv = new TestEnvironment();

    public Response canGiveResponseWithNoParameters(String  pathParam ) {
        String stackExchangeURL  =  testEnv.getBaseURL();
        String apiURL = stackExchangeURL + "/" + pathParam;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canGiveResponseUsingQuery(String endPoint, String  query ) {

        // Step 01: Parse response from page
        String stackExchangeURL  =  testEnv.getBaseURL();
        String apiURL = stackExchangeURL + "/" + endPoint + "#" + query;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        // System.out.println(response.prettyPeek());
        return response;
    }
}


