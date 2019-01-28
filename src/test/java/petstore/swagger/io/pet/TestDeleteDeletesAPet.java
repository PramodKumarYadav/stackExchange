package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeleteDeletesAPet {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void deleteExistingPetID() {

        // First create a request to ensure the ID exists for deletion
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        Response responsepost = petMethods.postAddANewPetToTheStore("pet",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsepost.getStatusCode());

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Delete the pet using petID (so response code 200)
        Response responseDelete = petMethods.deleteDeletesAPet("pet", petID);
        assertResponse.canAssertResponseStatus(200,responseDelete.getStatusCode());

        // Search to ensure that pet was deleted (so not found).
        Response responseGet = petMethods.getFindPetByID("pet",petID);
        assertResponse.canAssertResponseStatus(404,responseGet.getStatusCode());
    }
    @Test
    public void tryDeleteingNonExistingPetID() {
        Response responseDelete = petMethods.deleteDeletesAPet("pet", "6281930314171690275");
        assertResponse.canAssertResponseStatus(404,responseDelete.getStatusCode());
    }
    @Test
    public void tryDeleteingInvalidPetID() {
        Response responseDelete = petMethods.deleteDeletesAPet("pet", "abcdefgh");
        assertResponse.canAssertResponseStatus(400,responseDelete.getStatusCode());
    }
    @Test
    public  void canGiveResponseUsingPath() {
        String apiURL  =   "https://api.stackexchange.com/docs/badges?order=desc&sort=rank&site=stackoverflow" ;
//        String apiURL = stackExchangeURL + "/" + pathParam + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        System.out.println(response.prettyPeek());
//        return response;
    }
}
