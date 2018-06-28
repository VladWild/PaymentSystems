package com.epam.paymentsystems.algorithms.luhn;

public abstract class DAOLuhn {

    private static boolean isEvenCountDigit(int countDigit){
        return countDigit % 2 == 0;
    }

    public static LuhnAlgorithm getInstance(int countDigit){
        if (isEvenCountDigit(countDigit)) {
            return new LuhnEven();
        } else {
            return new LuhnOdd();
        }
    }
}
