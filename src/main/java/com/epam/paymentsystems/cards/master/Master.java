package com.epam.paymentsystems.cards.master;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;

public class Master extends Card implements MasterCard{
    public Master(FactoryCard type) {
        super(type);
    }

    public Master(FactoryCard type, int countDigits) {
        super(type, countDigits);
    }

    @Override
    protected int getSystemDigit() {
        return SYSTEM;
    }

    @Override
    protected int[] getTypeCard() {
        return new int[]{2, 5, 6, 7, 5};
    }
}
