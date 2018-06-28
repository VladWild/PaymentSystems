package com.epam.paymentsystems.cards;

import com.epam.paymentsystems.cards.master.ElectronicMaster;
import com.epam.paymentsystems.cards.master.MaestroMaster;
import com.epam.paymentsystems.cards.master.Master;
import com.epam.paymentsystems.cards.mir.ClassicMir;
import com.epam.paymentsystems.cards.mir.DebitMir;
import com.epam.paymentsystems.cards.mir.PremiumMir;
import com.epam.paymentsystems.cards.visa.ClassicVisa;
import com.epam.paymentsystems.cards.visa.ElectronVisa;
import com.epam.paymentsystems.cards.visa.GoldVisa;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public enum FactoryCard {
    VISA_ELECTRON {
        @Override
        protected Card getCard() {
            return new ElectronVisa(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new ElectronVisa(this, countDigits);
        }
    }, VISA_CLASSIC {
        @Override
        protected Card getCard() {
            return new ClassicVisa(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new ClassicVisa(this, countDigits);
        }
    }, VISA_GOLD {
        @Override
        protected Card getCard() {
            return new GoldVisa(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new GoldVisa(this, countDigits);
        }
    }, MASTER_MASTERCARD {
        @Override
        protected Card getCard() {
            return new Master(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new Master(this, countDigits);
        }
    }, MASTER_ELECTRONIC {
        @Override
        protected Card getCard() {
            return new ElectronicMaster(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new ElectronicMaster(this, countDigits);
        }
    }, MAESTRO {
        @Override
        protected Card getCard() {
            return new MaestroMaster(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new MaestroMaster(this, countDigits);
        }
    }, MIR_CLASSIC {
        @Override
        protected Card getCard() {
            return new ClassicMir(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new ClassicMir(this, countDigits);
        }
    }, MIR_PREMIUM {
        @Override
        protected Card getCard() {
            return new PremiumMir(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new PremiumMir(this, countDigits);
        }
    }, MIR_DEBIT {
        @Override
        protected Card getCard() {
            return new DebitMir(this);
        }

        @Override
        protected Card getCard(int countDigits) {
            return new DebitMir(this, countDigits);
        }
    };

    private static final Logger LOGGER = Logger.getLogger(FactoryCard.class);

    private static Card getTypeCard(FactoryCard typeCard) {
        LOGGER.debug("Create \"" + typeCard.toString() + "\" card with default count digit");
        return typeCard.getCard();
    }

    public static List<Card> getCards(List<String> cards) throws IllegalArgumentException {
        return cards.stream().
                map(FactoryCard::valueOf).
                        map(FactoryCard::getTypeCard).
                        collect(Collectors.toList());
    }

    private static Card getTypeCard(FactoryCard typeCard, int countDigits) {
        LOGGER.debug("Create \"" + typeCard.toString() + "\" card with count digit - " + countDigits);
        return typeCard.getCard(countDigits);
    }

    public static List<Card> getCards(List<String> cards, int countDigits) throws IllegalArgumentException {
        return cards.stream().
                map(FactoryCard::valueOf).
                map(card -> getTypeCard(card, countDigits)).
                collect(Collectors.toList());
    }

    protected abstract Card getCard();

    protected abstract Card getCard(int countDigits);
}



