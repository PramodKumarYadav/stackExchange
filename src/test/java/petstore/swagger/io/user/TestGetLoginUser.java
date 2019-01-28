package petstore.swagger.io.user;

import domainentitites.UserMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetLoginUser {
    UserMethods userMethods = new UserMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void LoginUserWithDefaultUserNamePasswordUsingFullQuery() {
        Response response = userMethods.getLogsUserIntoTheSystem("user/login","username=user1&password=pass@123");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
