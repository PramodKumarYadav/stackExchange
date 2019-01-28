package petstore.swagger.io.user;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetUserByUserName {
    UserMethods userMethods = new UserMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    // As per interface giving more than 10 is not allowed in webApplication (however it is allowed in API)
    public void searchWithExistingDefaultUserID() {
        Response response = userMethods.getGetUserByUserName("user","user1");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void searchWithIncorrectEndPoint() {
        Response response = userMethods.getGetUserByUserName("userrrr","user1");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void searchWithEmptyUserName() {
        Response response = userMethods.getGetUserByUserName("user","");
        assertResponse.canAssertResponseStatus(405,response.getStatusCode());
    }
    @Test
    public void searchWithInvalidUserName() {
        Response response = userMethods.getGetUserByUserName("user","abd#$%");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void searchWithNonExistingUserName() {
        Response response = userMethods.getGetUserByUserName("user","44234232523424234234211342347886");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
}
