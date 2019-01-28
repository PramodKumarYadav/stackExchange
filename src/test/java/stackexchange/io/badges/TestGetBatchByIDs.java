package stackexchange.io.badges;

import domainentitites.BadgeMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetBatchByIDs {
    BadgeMethods badgeMethods = new BadgeMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void searchWithSingleID() {
        Response responseGet = badgeMethods.getReturnAllBadgesOnTheSite("badges-by-ids","order=desc&sort=rank&ids=1&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void searchWithMultipleIDs() {
        Response responseGet = badgeMethods.getReturnAllBadgesOnTheSite("badges-by-ids","order=desc&sort=rank&ids=1%3B2&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }

}
