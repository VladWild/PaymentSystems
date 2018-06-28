package com.epam.paymentsystems.algorithms;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LuhnEvenAlgorithmTest {
    private final static int COUNT_DIGITS_DEFAULT = 16;
    private final static int SPECIFIED_DIGITS = 20;

    private String[] allCards = {
            "VISA_ELECTRON", "VISA_CLASSIC", "VISA_GOLD",
            "MASTER_MASTERCARD", "MASTER_ELECTRONIC", "MAESTRO",
            "MIR_CLASSIC", "MIR_PREMIUM", "MIR_DEBIT"
    };

    @Test
    public void divisionByTenWithDefaultCountDigits(){
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards));

        int[][] verNumberCards = new int[allCards.length][COUNT_DIGITS_DEFAULT];
        for (int i = 0; i < verNumberCards.length; i++) {
            verNumberCards[i] = getVerificationNumberCard(cards.get(i).getNumber());
        }

        for (int[] verNumberCard : verNumberCards) {
            assertTrue(IntStream.of(verNumberCard).sum() % 10 == 0);
        }
    }

    @Test
    public void divisionByTenWithSpecifiedCountDigits(){
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards), SPECIFIED_DIGITS);

        int[][] verNumberCards = new int[allCards.length][SPECIFIED_DIGITS];
        for (int i = 0; i < verNumberCards.length; i++) {
            verNumberCards[i] = getVerificationNumberCard(cards.get(i).getNumber());
        }

        for (int[] verNumberCard : verNumberCards) {
            assertTrue(IntStream.of(verNumberCard).sum() % 10 == 0);
        }
    }

    private int[] getVerificationNumberCard(int[] number){
        int[] verNumberCard = number.clone();

        for (int i = 0; i < number.length; i = i + 2){
            verNumberCard[i] *= 2;
            if (verNumberCard[i] > 9) {
                verNumberCard[i] = verNumberCard[i] % 10 + 1;
            }
        }

        return verNumberCard;
    }
}
