package stackexchange.io.comments;

import TestData.CreatePetRequest;
import domainentitites.CommentsMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetAllCommentsOnSite {
    CommentsMethods commentsMethods = new CommentsMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    AssertResponse assertResponse = new AssertResponse();


    @Test
    public void canGetAllCommentsOnSiteInAlphabeticalOrder() {
        Response response = commentsMethods.getReturnAllCommentsOnTheSite("comments","order=desc&sort=creation&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
}
