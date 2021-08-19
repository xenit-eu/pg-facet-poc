package eu.xenit.poc.facets;

import java.util.Random;
import java.util.function.Supplier;

public class RandomStringGeneratorWithMaxCardinality implements Supplier<String> {

    private Random random = new Random();
    private String[] stringArray;

    public RandomStringGeneratorWithMaxCardinality(int minimumLength, int maximumLength, int cardinality) {
        if (cardinality <= 0) {
            throw new IllegalArgumentException("Cardinality must be strict positive");
        }
        stringArray = new String[cardinality];
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator(minimumLength, maximumLength);
        for (int i = 0; i < cardinality; i++) {
            stringArray[i] = randomStringGenerator.get();
        }
    }

    @Override
    public String get() {
        return stringArray[random.nextInt(stringArray.length)];
    }
}
