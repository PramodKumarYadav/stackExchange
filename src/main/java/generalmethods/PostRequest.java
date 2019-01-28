package generalmethods;

import TestData.CreatePetRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class PostRequest {
    TestEnvironment testEnv = new TestEnvironment();
    CreatePetRequest createPetRequest = new CreatePetRequest();

    public Response canPostRequestUsingBody(String  endPoint , String requestBody, String contentType ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                header("api_key","special-key").
                contentType(contentType).
                body(requestBody).
                post(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canPostRequestUsingPathAndParameters(String  endPoint , String value, String nameValue,  String statusValue,  String contentType ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                header("accept",contentType).
                param("name",nameValue).
                param("status",statusValue).
                post(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }

    public Response canPostRequestUsingPathAndFileParameter(String  endPoint , String value, String metadataValue,  String filePath,  String contentType ) {
        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endPoint + "/" + value +"/uploadImage";
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                header("accept",contentType).
                multiPart("file2","file=@Original2.jpg;type=image/jpeg").
                post(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
}
