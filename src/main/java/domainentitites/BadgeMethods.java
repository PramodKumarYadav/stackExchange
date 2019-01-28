package domainentitites;

import io.restassured.response.Response;
import generalmethods.*;

import java.util.List;

public class BadgeMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();

    public Response getReturnAllBadgesOnTheSite(String  endPointBadges , String filterQuery) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointBadges,filterQuery);
        return response;
    }
    public Response getFindBadgeByIDs(String  endPointBadgesByIDs , String idQuery) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointBadgesByIDs,idQuery);
        return response;
    }
}
