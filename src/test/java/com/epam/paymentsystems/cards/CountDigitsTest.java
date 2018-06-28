package com.epam.paymentsystems.cards;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CountDigitsTest {
    private final static int NUMBER_CARD_LENGTH_BY_DEFAULT = 16;

    private String[] allCards = {
            "VISA_ELECTRON", "VISA_CLASSIC", "VISA_GOLD",
            "MASTER_MASTERCARD", "MASTER_ELECTRONIC", "MAESTRO",
            "MIR_CLASSIC", "MIR_PREMIUM", "MIR_DEBIT"
    };

    @Test
    public void countDigitsOnCards(){
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards));
        cards.forEach(card ->
                assertTrue(NUMBER_CARD_LENGTH_BY_DEFAULT == card.getNumber().length));
    }
}
