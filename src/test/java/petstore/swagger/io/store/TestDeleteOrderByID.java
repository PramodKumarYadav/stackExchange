package petstore.swagger.io.store;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.*;
import io.restassured.response.Response;
import org.junit.Test;

public class TestDeleteOrderByID {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void tryDeleteingExistingOrderID() {
//
        // First create a order to ensure the order exists for deletion
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        Response responsePost = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Delete the order using orderID (so response code 200)
        Response responseDelete = storeMethods.deleteDeletesPurchaseOrderByID("store/order", orderID);
        assertResponse.canAssertResponseStatus(200,responseDelete.getStatusCode());

        // Search to ensure that order was deleted (so not found).
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order",orderID);
        assertResponse.canAssertResponseStatus(404,responseGet.getStatusCode());
    }
    @Test
    public void tryDeleteingNonExistingOrderID() {
        Response responseDelete = storeMethods.deleteDeletesPurchaseOrderByID("store/order", "112112323");
        assertResponse.canAssertResponseStatus(404,responseDelete.getStatusCode());
    }
    @Test
    public void tryDeleteingInvalidOrderID() {
        Response responseDelete = storeMethods.deleteDeletesPurchaseOrderByID("store/order", "abcdf");
        assertResponse.canAssertResponseStatus(404,responseDelete.getStatusCode());
    }

}