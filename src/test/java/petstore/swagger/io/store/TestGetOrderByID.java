package petstore.swagger.io.store;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetOrderByID {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void searchWithExistingOrderID() {

        // First create an order to ensure that order exists
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        Response responsePost = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order",orderID);
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());

    }
    @Test
    // As per interface giving more than 10 is not allowed in webApplication (however it is allowed in API)
    public void searchWithExistingOrderIDMoreThan10() {
        // First create an order to ensure that order exists
        String requestBody = createOrderRequest.canCreateCustomOrderRequestBody(11,27,12,"placed", true);
        Response responsePost = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,responsePost.getStatusCode());

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order",orderID);
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void searchWithIncorrectEndPoint() {
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/ord","11");
        assertResponse.canAssertResponseStatus(404,responseGet.getStatusCode());
    }
    @Test
    public void searchWithEmptyOrderID() {
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order","");
        assertResponse.canAssertResponseStatus(405,responseGet.getStatusCode());
    }
    @Test
    public void searchWithInvalidOrderID() {
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order","abd#$%");
        assertResponse.canAssertResponseStatus(404,responseGet.getStatusCode());
    }
    @Test
    public void searchWithNonExistingOrderID() {
        Response responseGet = storeMethods.getFindPurchaseOrderByID("store/order","44234232523424234234211342347886");
        assertResponse.canAssertResponseStatus(404,responseGet.getStatusCode());
    }
}
