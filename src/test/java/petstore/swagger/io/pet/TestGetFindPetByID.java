package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetFindPetByID {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void searchWithExistingPetID() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responseGet = petMethods.getFindPetByID("pet",petID);
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void searchWithNonExistingPetID() {
        Response response = petMethods.getFindPetByID("pet","12321135645242534534789");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void searchWithInvalidPetID() {
        Response response = petMethods.getFindPetByID("pet","abd#$%");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void searchWithEmptyPetID() {
        Response response = petMethods.getFindPetByID("pet","");
        assertResponse.canAssertResponseStatus(405,response.getStatusCode());
    }
}
