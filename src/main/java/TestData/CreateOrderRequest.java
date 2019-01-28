package TestData;

import generalmethods.RandomNrsAndStrings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateOrderRequest {

    RandomNrsAndStrings randomNrsAndStrings = new RandomNrsAndStrings();

    public String canCreateEmptyOrderRequestBody() {

        String  requestBody = "{\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateBadRequestBody() {
        String randomStatus = canGenerateRandomOrderStatus();
        Boolean randomComplete = canGenerateRandomOrderComplete();

        String  requestBody = "{{\n" +
                "  \"adabdidd\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "  \"petId\": "+ randomNrsAndStrings.canGenerateRandomInteger(50) +",\n" +
                "  \"quantity\": "+ randomNrsAndStrings.canGenerateRandomInteger(30) +",\n" +
                "  \"shipDate\": \"2018-12-29T17:35:00.479Z\",\n" +
                "  \"status\": \"" + randomStatus + "\",\n" +
                "  \"complete\": " + randomComplete + "\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateBasicOrderRequestBody() {
        String randomStatus = canGenerateRandomOrderStatus();
        Boolean randomComplete = canGenerateRandomOrderComplete();

        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "  \"petId\": "+ randomNrsAndStrings.canGenerateRandomInteger(50) +",\n" +
                "  \"quantity\": "+ randomNrsAndStrings.canGenerateRandomInteger(30) +",\n" +
                "  \"shipDate\": \"2018-12-29T17:35:00.479Z\",\n" +
                "  \"status\": \"" + randomStatus + "\",\n" +
                "  \"complete\": " + randomComplete + "\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;

    }
    public String canCreateCustomOrderRequestBody(int id, int petID, int quantity, String status, Boolean complete) {
        String  requestBody = "{\n" +
                "  \"id\": "+ id +",\n" +
                "  \"petId\": "+ petID +",\n" +
                "  \"quantity\": "+ quantity +",\n" +
                "  \"shipDate\": \"2018-12-29T17:35:00.479Z\",\n" +
                "  \"status\": \""  + status  + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    @Test
    public String canGenerateRandomOrderStatus() {
        Random generateRandom = new Random();
        Integer randomInteger = generateRandom.nextInt(3) ;
        System.out.println("Random Integer : " + randomInteger);

        List<String> status = new ArrayList<>();
        status.add("placed");
        status.add("approved");
        status.add("delivered ");

        String randomStatus = status.get(randomInteger);
        System.out.println(randomStatus);
        return randomStatus;
    }

    @Test
    public Boolean canGenerateRandomOrderComplete() {
        Random generateRandom = new Random();
        Integer randomInteger = generateRandom.nextInt(2) ;
        System.out.println("Random Integer : " + randomInteger);

        List<Boolean> status = new ArrayList<>();
        status.add(false);
        status.add(true);

        Boolean randomComplete = status.get(randomInteger);
        System.out.println(randomComplete);
        return randomComplete;
    }
}
