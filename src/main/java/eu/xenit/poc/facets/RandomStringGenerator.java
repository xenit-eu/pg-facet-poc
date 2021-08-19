package eu.xenit.poc.facets;

import java.util.Random;
import java.util.function.Supplier;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator implements Supplier<String> {
    private Random random = new Random();

    private int minimumLength;
    private int maximumLength;

    public RandomStringGenerator(int minimumLength, int maximumLength) {
        if(minimumLength < 0 || maximumLength < 0 || maximumLength - minimumLength < 0) {
            throw new IllegalArgumentException("minimumLength and maximumLength should by gte 0. maximumLength must be gte minimumLength");
        }
        this.minimumLength = minimumLength;
        this.maximumLength = maximumLength;
    }

    private int getRandomLength() {
        if (maximumLength == minimumLength) {
            return minimumLength;
        }
        return random.nextInt(maximumLength - minimumLength + 1) + minimumLength;
    }

    @Override
    public String get() {
        return RandomStringUtils.randomAlphanumeric(getRandomLength());
    }
}
