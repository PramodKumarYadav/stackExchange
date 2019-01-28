package stackexchange.io.comments;

import domainentitites.CommentsMethods;
import generalmethods.AssertResponse;
import generalmethods.RandomNrsAndStrings;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetCommentsByIDs {
    CommentsMethods commentsMethods = new CommentsMethods();
    AssertResponse assertResponse = new AssertResponse();
    RandomNrsAndStrings randomNrsAndStrings = new RandomNrsAndStrings();

    @Test
    public void searchWithSingleID() {

        // To do a data driven test, I would normally connect to a test database and use a range to test the responses.
        // However here, since I don't have access to database, I will generate a random range of data to do a data
        // driven test for SingleID

        // Test Random comment IDs with single ID as input in query

        Integer NumberOfIterations =  randomNrsAndStrings.canGenerateRandomInteger(7) + 1;
        System.out.println("NumberOfIDs :" + NumberOfIterations);
        String searchID = "";

        for (int i=1 ; i < NumberOfIterations ; i++){
                Integer getRandomIDbelow100 = randomNrsAndStrings.canGenerateRandomInteger(100);
            searchID = "ids=" + getRandomIDbelow100;

            System.out.println("searchIDs :" + searchID);

            Response responseGet = commentsMethods.getFindCommentsByIDs("comments-by-ids","order=desc&sort=creation&"+searchID+"&filter=default&site=stackoverflow&run=true");
            assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());
        }
    }
    @Test
    public void searchWithMultipleIDs() {

        // To do a data driven test, I would normally connect to a test database and use a range to test the responses.
        // However here, since I dont have access to database, I will generate a random range of allowed data to do a
        // data driven test.

        Integer NumberOfIDs =  randomNrsAndStrings.canGenerateRandomInteger(7) + 2;
        System.out.println("NumberOfIDs :" + NumberOfIDs);

        // String searchIDs = "ids=1%3B2%3B3";
        String searchIDs = "ids=";
        for (int i=1 ; i < NumberOfIDs ; i++){
            Integer getRandomIDbelow100 = randomNrsAndStrings.canGenerateRandomInteger(100);
            if (i== 1){
                searchIDs = searchIDs + getRandomIDbelow100;
            }
            else {
                searchIDs = searchIDs + "%3B" + getRandomIDbelow100;
            }
        }

        System.out.println("searchIDs :" + searchIDs);
        Response responseGet = commentsMethods.getFindCommentsByIDs("comments-by-ids","order=desc&sort=creation&" + searchIDs + "&filter=default&site=stackoverflow&run=true");
        assertResponse.canAssertResponseStatus(200,responseGet.getStatusCode());

    }
}
