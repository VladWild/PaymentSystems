package com.epam.paymentsystems.cards.master;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;

public class MaestroMaster extends Card implements MasterCard {
    public MaestroMaster(FactoryCard type) {
        super(type);
    }

    public MaestroMaster(FactoryCard type, int countDigits) {
        super(type, countDigits);
    }

    @Override
    protected int getSystemDigit() {
        return SYSTEM;
    }

    @Override
    protected int[] getTypeCard() {
        return new int[]{2, 2, 1, 8, 8};
    }
}
