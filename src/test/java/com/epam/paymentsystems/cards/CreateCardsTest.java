package com.epam.paymentsystems.cards;

import com.epam.paymentsystems.cards.master.*;
import com.epam.paymentsystems.cards.mir.*;
import com.epam.paymentsystems.cards.visa.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CreateCardsTest {

    @Test
    public void createElectronVisa(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("VISA_ELECTRON")).
                get(0);
        assertTrue(card instanceof ElectronVisa);
    }

    @Test
    public void createClassicVisa(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("VISA_CLASSIC")).
                get(0);
        assertTrue(card instanceof ClassicVisa);
    }

    @Test
    public void createGoldVisa(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("VISA_GOLD")).
                get(0);
        assertTrue(card instanceof GoldVisa);
    }

    @Test
    public void createMaster(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MASTER_MASTERCARD")).
                get(0);
        assertTrue(card instanceof Master);
    }

    @Test
    public void createElectronicMaster(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MASTER_ELECTRONIC")).
                get(0);
        assertTrue(card instanceof ElectronicMaster);
    }

    @Test
    public void createMaestroMaster(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MAESTRO")).
                get(0);
        assertTrue(card instanceof MaestroMaster);
    }

    @Test
    public void createClassicMir(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MIR_CLASSIC")).
                get(0);
        assertTrue(card instanceof ClassicMir);
    }

    @Test
    public void createPremiumMir(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MIR_PREMIUM")).
                get(0);
        assertTrue(card instanceof PremiumMir);
    }

    @Test
    public void createDebitMir(){
        Card card = FactoryCard.
                getCards(Collections.singletonList("MIR_DEBIT")).
                get(0);
        assertTrue(card instanceof DebitMir);
    }
}
