package domainentitites;

import generalmethods.*;
import io.restassured.response.Response;

public class StoreMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();

    public Response getReturnsPetInventoriesByStatus(String  endPointStoreInventory) {
        Response response = getRequest.canGiveResponseWithNoParameters(endPointStoreInventory);
        return response;
    }
    public Response getFindPurchaseOrderByID(String  endPointStoreOrder , String orderID) {
        Response response = getRequest.canGiveResponseUsingPath(endPointStoreOrder,orderID);
        return response;
    }
    public Response postPlaceAnOrderForAPet(String  endPointStoreOrder , String requestBodyOrder, String json_xml ) {
        Response response = postRequest.canPostRequestUsingBody(endPointStoreOrder, requestBodyOrder, "application/" + json_xml);
        return response;
    }
    public Response deleteDeletesPurchaseOrderByID(String  endPointStoreOrder , String orderID ) {
        Response response = deleteRequest.canDeleteElementUsingPath(endPointStoreOrder,orderID);
        return response;
    }
}
