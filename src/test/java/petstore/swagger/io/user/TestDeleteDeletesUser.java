package petstore.swagger.io.user;

import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestDeleteDeletesUser {
    UserMethods userMethods = new UserMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void tryDeleteingExistingUserByUserName() {
        Response response = userMethods.deleteDeletesUser("user","user1");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void tryDeleteingNonExistingUser() {
        Response response = userMethods.deleteDeletesUser("user","6281930314171690275");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
    @Test
    public void tryDeleteingInvalidUser() {
        Response response = userMethods.deleteDeletesUser("user","abcdefgh");
        assertResponse.canAssertResponseStatus(400,response.getStatusCode());
    }
}
