package generalmethods;

import org.junit.Test;

import java.util.Random;

public class RandomNrsAndStrings {
    @Test
    public Integer canGenerateRandomInteger(Integer bound) {
        Random generateRandom = new Random();
        int randomInteger = generateRandom.nextInt(bound);
        System.out.println("Random Integer : " + randomInteger);
        return randomInteger;
    }
}
