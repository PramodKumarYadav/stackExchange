package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGetFindPetsByStatus {
    PetMethods petMethods = new PetMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void searchWithStatusAvailable() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithStatusPending() {
        List<String> arguments = new ArrayList<>();
        arguments.add("pending");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithStatusSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("sold");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithAllThreeStatus() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("pending");
        arguments.add("sold");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithAvailableAndPending() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("pending");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithAvailableAndSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("sold");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithPendingAndSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("pending");
        arguments.add("sold");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }

    @Test
    public void searchWithEmptyArgument() {
        List<String> arguments = new ArrayList<>();
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void searchWithInvalidArgument() {
        List<String> arguments = new ArrayList<>();
        arguments.add("random");
        Response response = petMethods.getFindPetsByStatus("pet/findByStatus","status",arguments);
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
}
