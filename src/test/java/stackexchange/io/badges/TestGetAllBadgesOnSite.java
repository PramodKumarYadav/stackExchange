package stackexchange.io.badges;

import domainentitites.BadgeMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetAllBadgesOnSite {
    BadgeMethods badgeMethods = new BadgeMethods();
    AssertResponse assertResponse = new AssertResponse();


    @Test
    public void canGetAllBadgesOnSiteInAlphabeticalOrder() {
        Response response = badgeMethods.getFindBadgeByIDs("badges","order=desc&sort=rank&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
