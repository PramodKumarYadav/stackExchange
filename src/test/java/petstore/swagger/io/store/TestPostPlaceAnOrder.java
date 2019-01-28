package petstore.swagger.io.store;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostPlaceAnOrder {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void postOrderForAPetWithFullRequestBody() {
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        Response response = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithCustomRequestBody() {
        String requestBody = createOrderRequest.canCreateCustomOrderRequestBody(9,27,12,"placed", true);
        Response response = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createOrderRequest.canCreateEmptyOrderRequestBody();
        Response response = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(405,response.getStatusCode());
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createOrderRequest.canCreateBadRequestBody();
        Response response = storeMethods.postPlaceAnOrderForAPet("store/order",requestBody,"json");
        assertResponse.canAssertResponseStatus(400,response.getStatusCode());
    }
}
