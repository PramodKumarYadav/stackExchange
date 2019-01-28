package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPutUpdateUser {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void putRequestUpdateRandomDataStatusAvailable() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(123,"user1","pramod","yadav");
        Response response = userMethods.putUpdateUser("user","user1",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void putRequestUpdateEmptyStatusAvailable() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(123,"user1","","");
        Response response = userMethods.putUpdateUser("user","user1",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
