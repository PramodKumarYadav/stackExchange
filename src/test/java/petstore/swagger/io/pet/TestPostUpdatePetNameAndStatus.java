package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostUpdatePetNameAndStatus {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void postRequestUpdatenameAndStatus_pending() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response responseGet = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());

        // Get ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        petMethods.postUpdateAPetInStoreWithFormData("pet", petID, "POST_ChangeToPramod","pending","json");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void postRequestUpdatenameAndStatus_sold() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response responseGet = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());

        // Get ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        petMethods.postUpdateAPetInStoreWithFormData("pet", petID, "POST_ChangeToKumar","sold","json");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void postRequestUpdatenameAndStatus_available() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responsePostUpdate =  petMethods.postUpdateAPetInStoreWithFormData("pet", petID, "POST_ChangeToYadav","available","json");
        assertResponse.canAssertResponseStatus(200,responsePostUpdate.getStatusCode());
    }
    @Test
    public void postRequestUpdatenameAndStatus_Empty() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responsePostUpdate =  petMethods.postUpdateAPetInStoreWithFormData("pet", petID, "","","json");
        assertResponse.canAssertResponseStatus(200,responsePostUpdate.getStatusCode());
    }
}
