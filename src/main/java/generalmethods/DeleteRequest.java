package generalmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class DeleteRequest {

    TestEnvironment testEnv = new TestEnvironment();

    public Response canDeleteElementUsingPath(String  endpoint, String value) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endpoint + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.given().request().
                delete(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canDeleteElementUsingPath(String apiKey, String  pathParam, String value) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.given().request().
                header("auth_token","special-key").
                delete(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
}


