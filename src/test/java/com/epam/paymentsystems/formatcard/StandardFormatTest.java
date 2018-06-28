package com.epam.paymentsystems.formatcard;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class StandardFormatTest {
    private String[] allCards = {"VISA_ELECTRON", "VISA_CLASSIC", "VISA_GOLD",
            "MASTER_MASTERCARD", "MASTER_ELECTRONIC", "MAESTRO",
            "MIR_CLASSIC", "MIR_PREMIUM", "MIR_DEBIT"};

    private static final int COUNT_DIGITS = 25;

    private Format standard;

    @Before
    public void createFormat(){
        standard = FactoryFormatCard.getTypeFormat(FactoryFormatCard.STANDART);
    }

    @Test
    public void getFormatNumberWithDefaultCountDigitsTest() {
        final String regex = ""//
                + "[[A-Z]\\s]*\\n"//
                + "(\\d{4}\\s?){4}";
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards));

        for (Card card : cards) {
            assertTrue(Pattern.compile(regex).
                    matcher(standard.getFormat(card)).find());
        }
    }

    @Test
    public void getFormatNumberWithNonDefaultCountDigitsTest() {
        final String regex = ""//
                + "[[A-Z]\\s]*\\n"//
                + "(\\d{4}\\s?)*";
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards), COUNT_DIGITS);

        for (Card card : cards) {
            assertTrue(Pattern.compile(regex).
                    matcher(standard.getFormat(card)).find());
        }
    }

    @After
    public void destroyReport(){
        standard = null;
    }
}
