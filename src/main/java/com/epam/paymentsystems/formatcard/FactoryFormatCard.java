package com.epam.paymentsystems.formatcard;

import com.epam.paymentsystems.algorithms.Algorithm;

public enum FactoryFormatCard {
    STANDART {
        @Override
        protected Format getFormat() {
            return new StandardFormat();
        }
    };

    protected abstract Format getFormat();

    public static Format getTypeFormat(FactoryFormatCard typeFormat){
        return typeFormat.getFormat();
    }
}
