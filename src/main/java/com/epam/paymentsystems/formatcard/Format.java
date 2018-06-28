package com.epam.paymentsystems.formatcard;

import com.epam.paymentsystems.cards.Card;

public interface Format {
    String getFormat(Card card);
}
