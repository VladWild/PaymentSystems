package com.epam.paymentsystems.cards;

import com.epam.paymentsystems.algorithms.Algorithm;
import com.epam.paymentsystems.algorithms.FactoryAlgorithm;
import com.epam.paymentsystems.formatcard.FactoryFormatCard;
import com.epam.paymentsystems.formatcard.Format;
import com.epam.paymentsystems.generators.FactoryGenerator;
import com.epam.paymentsystems.generators.Generator;
import org.apache.log4j.Logger;

import java.util.Arrays;

public abstract class Card {
    private static final Logger LOGGER = Logger.getLogger(Card.class);

    private static final int COUNT_DIGITS_DEFAULT = 16;

    private static final Format FORMAT = FactoryFormatCard.
            getTypeFormat(FactoryFormatCard.STANDART);
    private static final Generator GENERATOR = FactoryGenerator.
            getTypeGenerator(FactoryGenerator.RANDOM);

    private final Algorithm ALGORITHM;

    private String name;
    private int countDigits;
    private int[] type;

    private int[] number;

    public Card(FactoryCard type) {
        name = type.toString();
        this.type = getTypeCard();
        countDigits = COUNT_DIGITS_DEFAULT;
        ALGORITHM = FactoryAlgorithm.
                getTypeAlgorithm(FactoryAlgorithm.LUHN, COUNT_DIGITS_DEFAULT);
        initNumberCard();
    }

    public Card(FactoryCard type, int countDigits) {
        name = type.toString();
        this.type = getTypeCard();
        this.countDigits = countDigits;
        ALGORITHM = FactoryAlgorithm.
                getTypeAlgorithm(FactoryAlgorithm.LUHN, countDigits);
        initNumberCard();
    }

    private void initDigitPaymentSystem() {
        number[0] = getSystemDigit();
    }

    private void initTypeCard() {
        System.arraycopy(type, 0, number, 1, type.length);
    }

    private void initBankIdentifier() {
        LOGGER.debug("Getting the digit of payment system");
        initDigitPaymentSystem();
        LOGGER.debug("Getting the number of type card");
        initTypeCard();
    }

    private void initIdentificationNumber() {
        LOGGER.debug("Get identification number from GENERATOR");
        int[] digit = GENERATOR.getDigits(countDigits - type.length - 2);
        LOGGER.debug("Saving an identification number to the card number");
        System.arraycopy(digit, 0, number, 6, digit.length);
    }

    private void initCheckDigit() {
        LOGGER.debug("Get and saving check digit");
        number[countDigits - 1] = ALGORITHM.getVerificationDigit(number);
    }

    private void initUniqueNumber() {
        LOGGER.debug("Getting of identification number");
        initIdentificationNumber();
        LOGGER.debug("Getting the check number");
        initCheckDigit();
    }

    private void initNumberCard() {
        LOGGER.debug("Initializing the card number");
        number = new int[countDigits];
        LOGGER.debug("Formation a bank identifier");
        initBankIdentifier();
        LOGGER.debug("Formation a unique number");
        initUniqueNumber();
        LOGGER.debug("The generated card number has the next number - " + Arrays.toString(number));
    }

    abstract protected int getSystemDigit();

    abstract protected int[] getTypeCard();

    public int[] getNumber() {
        return number;
    }

    public String getNameCard(){
        return name;
    }

    @Override
    public String toString() {
        return FORMAT.getFormat(this);
    }
}



