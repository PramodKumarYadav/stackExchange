package stackexchange.io.comments;

import domainentitites.BadgeMethods;
import domainentitites.CommentsMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetCommentsByIDs {
    CommentsMethods commentsMethods = new CommentsMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void searchWithSingleID() {
        Response responseGet = commentsMethods.getFindCommentsByIDs("comments-by-ids","order=desc&sort=creation&ids=1&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }
    @Test
    public void searchWithMultipleIDs() {
        Response responseGet = commentsMethods.getFindCommentsByIDs("comments-by-ids","order=desc&sort=creation&ids=1%3B2%3B3&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
    }

}
