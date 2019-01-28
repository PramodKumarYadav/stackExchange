package generalmethods;

import org.junit.Test;

import java.util.Random;

public class RandomNrsAndStrings {

    public String canGenerateRandomString(Integer bound) {
        //Pramod : Customizing for my needs; this method is from : https://www.baeldung.com/java-random-string
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = bound;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println("Random String : " + generatedString);
        return generatedString;
    }
    @Test
    public Integer canGenerateRandomInteger(Integer bound) {
        Random generateRandom = new Random();
        int randomInteger = generateRandom.nextInt(bound);
        System.out.println("Random Integer : " + randomInteger);
        return randomInteger;
    }
}
