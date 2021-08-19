package eu.xenit.poc.facets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomStringGeneratorTest {

    @Test
    void testGenerate() {
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator(5, 5);
        String random = randomStringGenerator.get();
        Assertions.assertEquals(5, random.length());

        randomStringGenerator = new RandomStringGenerator(0, 0);
        random = randomStringGenerator.get();
        Assertions.assertEquals(0, random.length());

        randomStringGenerator = new RandomStringGenerator(3, 7);
        random = randomStringGenerator.get();
        Assertions.assertTrue(random.length() > 2);
        Assertions.assertTrue(random.length() < 8);
    }

}