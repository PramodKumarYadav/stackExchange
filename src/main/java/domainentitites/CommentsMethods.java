package domainentitites;

import generalmethods.DeleteRequest;
import generalmethods.GetRequest;
import generalmethods.PostRequest;
import io.restassured.response.Response;

public class CommentsMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();

    public Response getReturnAllCommentsOnTheSite(String  endPointComments , String filterQuery) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointComments,filterQuery);
        return response;
    }
    public Response getFindCommentsByIDs(String  endPointCommentsByIDs , String idQuery) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointCommentsByIDs,idQuery);
        return response;
    }
}
