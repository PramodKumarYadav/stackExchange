package domainentitites;

import io.restassured.response.Response;
import generalmethods.*;

import java.util.List;

public class PetMethods {
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();

    public Response getFindPetByID(String  endPointPet , String petID) {
        Response response = getRequest.canGiveResponseUsingPath(endPointPet,petID);
        return response;
    }
    public Response getFindPetsByStatus(String endPointPetFindByStatus, String  pathStatus , List<String> statusArguments) {
        Response response = getRequest.canGiveResponseUsingQuery(endPointPetFindByStatus,pathStatus,statusArguments);
        return response;
    }
    public Response postAddANewPetToTheStore(String  endPointPet , String requestBodyPet, String json_xml ) {
        Response response = postRequest.canPostRequestUsingBody(endPointPet, requestBodyPet, "application/" + json_xml);
        return response;
    }
    public Response postUpdateAPetInStoreWithFormData(String  endPointPet , String petID, String nameValue,  String statusValue, String json_xml ) {
        Response response = postRequest.canPostRequestUsingPathAndParameters(endPointPet, petID, nameValue, statusValue,"application/" + json_xml);
        return response;
    }
    public Response postUploadAnImage(String  endPointPet_id_uploadImage , String petID, String metadataValue,  String filePath, String json_xml ) {
        Response response = postRequest.canPostRequestUsingPathAndFileParameter(endPointPet_id_uploadImage, petID, metadataValue, filePath,"application/" + json_xml);
        return response;
    }
    public Response putUpdateAnExistingPet(String  endPointPet , String requestBodyPet, String json_xml ) {
        Response response = putRequest.canPutRequestUsingBody(endPointPet, requestBodyPet, "application/" + json_xml);
        return response;
    }
    public Response deleteDeletesAPet(String  endPointPet , String petID ) {
        Response response = deleteRequest.canDeleteElementUsingPath(endPointPet,petID);
        return response;
    }
}
