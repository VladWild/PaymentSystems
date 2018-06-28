package com.epam.paymentsystems.cards.mir;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;

public class PremiumMir extends Card implements Mir {
    public PremiumMir(FactoryCard type) {
        super(type);
    }

    public PremiumMir(FactoryCard type, int countDigits) {
        super(type, countDigits);
    }

    @Override
    protected int getSystemDigit() {
        return SYSTEM;
    }

    @Override
    protected int[] getTypeCard() {
        return new int[]{2, 2, 0, 4, 5};
    }
}
