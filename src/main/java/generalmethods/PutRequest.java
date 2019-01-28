package generalmethods;

import TestData.CreatePetRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class PutRequest {
    TestEnvironment testEnv = new TestEnvironment();
    CreatePetRequest createPetRequest = new CreatePetRequest();

    public Response canPutRequestUsingBody(String  endPoint , String requestBody, String contentType ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                contentType(contentType).
                body(requestBody).
                put(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canPutRequestUsingBodyAndPath(String  endPoint , String value, String requestBody, String contentType ) {

        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                contentType(contentType).
                body(requestBody).
                put(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
}
