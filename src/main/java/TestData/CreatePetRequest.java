package TestData;

import generalmethods.RandomNrsAndStrings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatePetRequest {
    RandomNrsAndStrings randomNrsAndStrings = new RandomNrsAndStrings();

    public String canCreateEmptyPetRequestBody() {

        String  requestBody = "{\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateBadPetRequestBody() {

        String  requestBody = "{{\n" +
                "  \"idadfas\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",  \n" +
                "  \"name\": \"" + randomNrsAndStrings.canGenerateRandomString(6) + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(100) +",\n" +
                "    \"name\": \"BullDog\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadav\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }

    public String canCreateBasicPetRequestBody() {

        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",  \n" +
                "  \"name\": \"" + randomNrsAndStrings.canGenerateRandomString(6) + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(100) +",\n" +
                "    \"name\": \"BullDog\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadav\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateFullPetRequestBody() {

        Random generateRandom = new Random();
        long randomLongID = generateRandom.nextLong();
        System.out.println("id : " + randomLongID);

        String randomStatus = canGenerateRandomStatus();
        String randomCategory = canGenerateRandomPetCategory();

        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",  \n" +
                "  \"name\": \"" + randomNrsAndStrings.canGenerateRandomString(7) + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(100) +",\n" +
                "    \"name\": \"" + randomCategory + "\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "     \"http://porodasobak.net/img/uploads/2014/08/1291.jpg\" ," +
                "     \"https://www.ptichka.ru/data/cache/2018mar/19/03/64590_14562.jpg\" " +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadavTag1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadavTag2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + randomStatus + "\"\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateCustomPetRequestBody(String id, String name, String status) {

        System.out.println("id : " + id);
        System.out.println("name : " + name);
        System.out.println("status : " + status);

        String randomCategory = canGenerateRandomPetCategory();

        String  requestBody = "{\n" +
                "  \"id\": "+ id +",  \n" +
                "  \"name\": \"" + name+ "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",\n" +
                "    \"name\": \"" + randomCategory + "\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "     \"http://porodasobak.net/img/uploads/2014/08/1291.jpg\" ," +
                "     \"https://www.ptichka.ru/data/cache/2018mar/19/03/64590_14562.jpg\" " +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadavTag1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "      \"name\": \"byPramodYadavTag2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

//        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    @Test
    public String canGenerateRandomStatus() {
        Random generateRandom = new Random();
        Integer randomInteger = generateRandom.nextInt(3) ;
        System.out.println("Random Integer : " + randomInteger);

        List<String> status = new ArrayList<>();
        status.add("available");
        status.add("pending");
        status.add("sold");

        String randomStatus = status.get(randomInteger);
        System.out.println(randomStatus);
        return randomStatus;
    }
    @Test
    public String canGenerateRandomPetCategory() {
        Random generateRandom = new Random();
        Integer randomInteger = generateRandom.nextInt(5) ;
        System.out.println("Random Integer : " + randomInteger);

        List<String> category = new ArrayList<>();
        category.add("dog");
        category.add("cat");
        category.add("horse");
        category.add("bird");
        category.add("cow");

        String randomCategory = category.get(randomInteger);
        System.out.println(randomCategory);
        return randomCategory;
    }

}

