package stackexchange.io.badges;

import domainentitites.BadgeMethods;
import generalmethods.AssertResponse;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestGetBatchByIDsSchemaValidation {
    BadgeMethods badgeMethods = new BadgeMethods();
    AssertResponse assertResponse = new AssertResponse();
    @Test
    public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {
        Response responseGet = badgeMethods.getReturnAllBadgesOnTheSite("badges-by-ids","order=desc&sort=rank&ids=1%3B2&filter=default&site=stackoverflow&run=true");
        responseGet.then().assertThat()
                .body(matchesJsonSchemaInClasspath("badge-schema.json"));
    }

}
