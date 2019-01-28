package petstore.swagger.io.user;

import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetLogoutUser {
    UserMethods userMethods = new UserMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void logoutCurrentUserSession() {
        Response response = userMethods.getLogsOutCurrentLoggedInUserSession("user/logout");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void logoutCurrentUserSessionInvalidEndPoint() {
        Response response = userMethods.getLogsOutCurrentLoggedInUserSession("user/logouttttt");
        assertResponse.canAssertResponseStatus(500,response.getStatusCode());
    }
}
