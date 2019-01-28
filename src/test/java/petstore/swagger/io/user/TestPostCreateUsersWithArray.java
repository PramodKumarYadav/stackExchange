package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestPostCreateUsersWithArray {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    // TODO : There seems to be issue on server side, creating users as mentioned on swagger site
    // [Ticket is still open @Swagger site.]. https://github.com/swagger-api/swagger-editor/issues/1474
    public void postRequestWithFullRequestBody() {
        String requestBody = createUserRequest.canCreateListOfUsersRequestBody(3);
        Response response = userMethods.postCreateListOfUsersWithGivenInputArray("user/createWithArray",requestBody,"json");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }

}
