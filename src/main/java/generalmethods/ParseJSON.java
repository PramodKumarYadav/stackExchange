package generalmethods;

import io.restassured.path.json.JsonPath;

public class ParseJSON {
    public String canReturnAKeyValuefromJSONStringBody(String  jsonBodyInStringFormat, String KeyName, String TagExpectedActual) {
        JsonPath jsonPath = new JsonPath(jsonBodyInStringFormat);
        String keyValue = jsonPath.getString(KeyName);
        System.out.println(TagExpectedActual + " " + KeyName + " : " + keyValue);
        return keyValue;
    }
}
