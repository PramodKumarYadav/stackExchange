package generalmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

import java.util.List;

public class GetRequest {

    TestEnvironment testEnv = new TestEnvironment();

    public Response canGiveResponseWithNoParameters(String  pathParam ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canGiveResponseUsingPath(String  pathParam , String value ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam + "/" + value;
        // System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        // System.out.println(response.prettyPeek());
        return response;
    }

    public Response canGiveResponseUsingQuery(String endPoint, String  pathParam , List<String> values ) {
        // Step 01: Parse response from page
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint;
        for (int i=0; i<values.size(); i++){
            if (i == 0) {
                apiURL = apiURL + "?" +  pathParam + "=" + values.get(i);
            } else {
                apiURL = apiURL + "&" + pathParam + "=" + values.get(i);
            }
        }
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        // System.out.println(response.prettyPeek());
        return response;
    }

    public Response canGiveResponseUsingFullQueryAsInput(String endPoint, String  query ) {

        // Step 01: Parse response from page
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint + "?" + query;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        // System.out.println(response.prettyPeek());
        return response;
    }
}


