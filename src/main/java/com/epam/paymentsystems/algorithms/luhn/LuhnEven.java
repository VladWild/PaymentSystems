package com.epam.paymentsystems.algorithms.luhn;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class LuhnEven extends LuhnAlgorithm{
    private static final Logger LOGGER = Logger.getLogger(LuhnEven.class);

    @Override
    protected int[] getChangeNumber(int[] number) {
        LOGGER.trace("In the card even count digit - " + number.length);
        LOGGER.trace("Array source number is - " + Arrays.toString(number));
        int[] changeNumber = number.clone();

        for (int i = 0; i < number.length; i = i + 2){
            changeNumber[i] *= 2;
            if (changeNumber[i] > 9) {
                changeNumber[i] = changeNumber[i] % 10 + 1;
            }
        }

        LOGGER.trace("Array change number is forming - " + Arrays.toString(changeNumber));
        return changeNumber;
    }
}
