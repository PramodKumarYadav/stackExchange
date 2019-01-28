package stackexchange.io.privileges;

import domainentitites.PrivilegesMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetAllPrivileges {
    PrivilegesMethods privilegesMethods = new PrivilegesMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void canGetAllCommentsOnSiteInAlphabeticalOrder() {
        Response response = privilegesMethods.getReturnAllPrivilegesOnTheSite("privileges","filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
