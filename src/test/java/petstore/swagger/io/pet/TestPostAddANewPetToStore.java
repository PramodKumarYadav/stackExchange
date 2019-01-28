package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostAddANewPetToStore {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void postRequestWithBasicRequestBody() {
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        Response response = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithFullRequestBody() {
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        Response response = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createPetRequest.canCreateEmptyPetRequestBody();
        Response response = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(405,response.getStatusCode());
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createPetRequest.canCreateBadPetRequestBody();
        Response response = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(400,response.getStatusCode());
    }

}
