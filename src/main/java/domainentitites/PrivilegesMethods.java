package domainentitites;

import generalmethods.DeleteRequest;
import generalmethods.GetRequest;
import generalmethods.PostRequest;
import io.restassured.response.Response;

public class PrivilegesMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();

    public Response getReturnAllPrivilegesOnTheSite(String  endPointPrivileges , String filterQuery) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointPrivileges,filterQuery);
        return response;
    }
}
