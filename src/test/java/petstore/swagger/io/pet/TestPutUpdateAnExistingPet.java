package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import TestData.CreatePetRequest;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPutUpdateAnExistingPet {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();


    @Test
    public void putRequestUpdateRandomDataStatusAvailable() {

        // First create a request to ensure the ID exists for search
        String requestBodyBasic = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBodyBasic,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyBasic.toString(),"id","Search using ");

        // Generate a new body to update existing request
        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","available");

        // Update the pet element
        Response response = petMethods.putUpdateAnExistingPet("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());

    }
    @Test
    public void putRequestUpdateRandomDataPending() {
        // First create a request to ensure the ID exists for search
        String requestBodyBasic = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBodyBasic,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyBasic.toString(),"id","Search using ");

        // Generate a new body to update existing request
        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","pending");

        // Update the pet element
        Response response = petMethods.putUpdateAnExistingPet("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void putRequestUpdateRandomDataSold() {
        // First create a request to ensure the ID exists for search
        String requestBodyBasic = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBodyBasic,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyBasic.toString(),"id","Search using ");

        // Generate a new body to update existing request
        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","sold");

        // Update the pet element
        Response response = petMethods.putUpdateAnExistingPet("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void putRequestUpdateRandomDataEmptyNameAndStatus() {
        // First create a request to ensure the ID exists for search
        String requestBodyBasic = createPetRequest.canCreateFullPetRequestBody();
        Response responsePost = petMethods.postAddANewPetToTheStore("pet",requestBodyBasic,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyBasic.toString(),"id","Search using ");

        // Generate a new body to update existing request
        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","");

        // Update the pet element
        Response response = petMethods.putUpdateAnExistingPet("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
