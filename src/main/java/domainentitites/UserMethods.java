package domainentitites;

import generalmethods.*;
import io.restassured.response.Response;

public class UserMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();
    public Response getGetUserByUserName(String  endPointUser , String username ) {
        Response response = getRequest.canGiveResponseUsingPath(endPointUser,username);
        return response;
    }
    public Response getLogsOutCurrentLoggedInUserSession(String  endPointUserLogout ) {
        Response response = getRequest.canGiveResponseWithNoParameters(endPointUserLogout);
        return response;
    }
    public Response getLogsUserIntoTheSystem(String endPointUserLogin, String  queryUsernamePassword  ) {
        Response response = getRequest.canGiveResponseUsingFullQueryAsInput(endPointUserLogin,queryUsernamePassword);
        return response;
    }
    public Response postCreateUser(String  endPointUser , String requestBodyUser, String json_xml ) {
        Response response = postRequest.canPostRequestUsingBody(endPointUser, requestBodyUser, "application/" + json_xml);
        return response;
    }
    public Response postCreateListOfUsersWithGivenInputArray(String  endPointUserCreateWithArray , String requestBodyUser, String json_xml ) {
        Response response = postRequest.canPostRequestUsingBody(endPointUserCreateWithArray, requestBodyUser, "application/" + json_xml);
        return response;
    }
    public Response postCreateListOfUsersWithGivenInputList(String  endPointUserCreateWithList , String requestBodyUser, String json_xml ) {
        Response response = postRequest.canPostRequestUsingBody(endPointUserCreateWithList, requestBodyUser, "application/" + json_xml);
        return response;
    }
    public Response putUpdateUser(String  endPointUser , String username, String requestBodyUser, String json_xml ) {
        Response response = putRequest.canPutRequestUsingBody(endPointUser, requestBodyUser, "application/" + json_xml);
        return response;
    }
    public Response deleteDeletesUser(String  endPointUser , String username ) {
        Response response = deleteRequest.canDeleteElementUsingPath(endPointUser,username);
        return response;
    }
}
