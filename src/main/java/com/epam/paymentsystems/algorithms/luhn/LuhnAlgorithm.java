package com.epam.paymentsystems.algorithms.luhn;

import com.epam.paymentsystems.algorithms.Algorithm;
import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public abstract class LuhnAlgorithm implements Algorithm {
    private static final Logger LOGGER = Logger.getLogger(LuhnAlgorithm.class);

    abstract protected int[] getChangeNumber(int[] number);

    private int getSum(int[] number){
        LOGGER.trace("The sum change number - " + IntStream.of(number).sum());
        return IntStream.of(number).sum();
    }

    private int getValue(int sum){
        int value = 10 - (sum % 10);
        if (value != 10) {
            LOGGER.trace("The check digit - " + value);
        } else {
            LOGGER.trace("The check digit - 0");
        }
        return value != 10 ? value : 0;
    }

    @Override
    public int getVerificationDigit(int[] number) {
        return getValue(getSum(getChangeNumber(number)));
    }
}

