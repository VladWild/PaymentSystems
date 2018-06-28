package com.epam.paymentsystems.algorithms;

import com.epam.paymentsystems.algorithms.luhn.DAOLuhn;

public enum FactoryAlgorithm {
    LUHN {
        @Override
        protected Algorithm getAlgorithm(int countDigit) {
            return DAOLuhn.getInstance(countDigit);
        }
    };

    protected abstract Algorithm getAlgorithm(int countDigit);

    public static Algorithm getTypeAlgorithm(FactoryAlgorithm typeAlgorithm, int countDigit){
        return typeAlgorithm.getAlgorithm(countDigit);
    }
}
