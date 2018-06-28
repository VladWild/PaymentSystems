package com.epam.paymentsystems.cards.visa;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;

public class GoldVisa extends Card implements Visa {
    public GoldVisa(FactoryCard type) {
        super(type);
    }

    public GoldVisa(FactoryCard type, int countDigits) {
        super(type, countDigits);
    }

    @Override
    protected int getSystemDigit() {
        return SYSTEM;
    }

    @Override
    protected int[] getTypeCard() {
        return new int[]{7, 9, 7, 3, 8};
    }
}
