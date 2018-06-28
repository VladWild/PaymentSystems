package com.epam.paymentsystems.parameters;

import com.epam.paymentsystems.cards.FactoryCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class InputParametersTest {
    private String[] allCards = {"VISA_ELECTRON", "VISA_CLASSIC", "VISA_GOLD",
            "MASTER_MASTERCARD", "MASTER_ELECTRONIC", "MAESTRO",
            "MIR_CLASSIC", "MIR_PREMIUM", "MIR_DEBIT"};

    private static final String NON_VALID_NAME_CARD = "NON_VALID_NAME";

    @Test(expected = Test.None.class)
    public void nonThrowsIllegalArgumentExceptionTest() {
        FactoryCard.getCards(Arrays.asList(allCards));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionTest() {
        FactoryCard.getCards(Collections.singletonList(NON_VALID_NAME_CARD));
    }


}

