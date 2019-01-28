package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostUploadAnImage {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    // TODO: 12/29/2018
    public void postRequestUpdatenameAndStatus_pending() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responsePostUpload = petMethods.postUploadAnImage("pet", petID, "dummy","dummy","json");
        assertResponse.canAssertResponseStatus(200,responsePostUpload.getStatusCode());

    }
}
