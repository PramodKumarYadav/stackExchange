package petstore.swagger.io.store;

import domainentitites.StoreMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetInventory {
    StoreMethods storeMethods = new StoreMethods();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void TestStoreInventory() {
        Response response = storeMethods.getReturnsPetInventoriesByStatus("store/inventory");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void TestStoreInventoryInvalidEndPoint() {
        Response response = storeMethods.getReturnsPetInventoriesByStatus("store/invent");
        assertResponse.canAssertResponseStatus(404,response.getStatusCode());
    }
}
