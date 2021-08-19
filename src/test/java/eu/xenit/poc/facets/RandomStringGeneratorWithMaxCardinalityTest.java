package eu.xenit.poc.facets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomStringGeneratorWithMaxCardinalityTest {

    @Test
    void testGenerate() {
        RandomStringGeneratorWithMaxCardinality randomStringGeneratorWithMaxCardinality = new RandomStringGeneratorWithMaxCardinality(5, 9, 1);
        String random = randomStringGeneratorWithMaxCardinality.get();
        Assertions.assertTrue(random.length() > 4);
        Assertions.assertTrue(random.length() < 10);
        Assertions.assertEquals(random, randomStringGeneratorWithMaxCardinality.get());
    }

}