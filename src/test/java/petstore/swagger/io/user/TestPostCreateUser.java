package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostCreateUser {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    // TODO : There seems to be issue on server side, creating users as mentioned on swagger site
    // [Ticket is still open @Swagger site.]. https://github.com/swagger-api/swagger-editor/issues/1474
    public void postRequestWithFullRequestBody() {
        String requestBody = createUserRequest.canCreateBasicUserRequestBody();
        Response response = userMethods.postCreateUser("user",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithCustomRequestBody() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(27,"userPramod","Pramod","Yadav");
        Response response = userMethods.postCreateUser("user",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createUserRequest.canCreateEmptyUserRequestBody();
        Response response = userMethods.postCreateUser("user",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createUserRequest.canCreateBadRequestBody();
        Response response = userMethods.postCreateUser("user",requestBody,"json");
        assertResponse.canAssertResponseStatus(400,response.getStatusCode());
    }
}
