package com.epam.paymentsystems.cards.visa;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;

public class ElectronVisa extends Card implements Visa {
    public ElectronVisa(FactoryCard type) {
        super(type);
    }

    public ElectronVisa(FactoryCard type, int countDigits) {
        super(type, countDigits);
    }

    @Override
    protected int getSystemDigit() {
        return SYSTEM;
    }

    @Override
    protected int[] getTypeCard() {
        return new int[]{4, 3, 9, 8, 4};
    }
}
