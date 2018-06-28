package com.epam.paymentsystems.generators;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

class RandomGenerator implements Generator {
    private static final Logger LOGGER = Logger.getLogger(RandomGenerator.class);

    @Override
    public int[] getDigits(final int COUNT) {
        LOGGER.trace("Creating random array digits size - " + COUNT);
        Random random = new Random();
        int[] number = new int[COUNT];
        for (int i = 0; i < number.length; i++) {
            number[i] = random.nextInt(10);
        }
        LOGGER.trace(number.length + " random digit are generated - " + Arrays.toString(number));
        return number;
    }
}
