package com.epam.paymentsystems.reports;

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
public class SimpleReportTest {
    private String[] allCards = {"VISA_ELECTRON", "VISA_CLASSIC", "VISA_GOLD",
            "MASTER_MASTERCARD", "MASTER_ELECTRONIC", "MAESTRO",
            "MIR_CLASSIC", "MIR_PREMIUM", "MIR_DEBIT"};

    private static final String NON_VALID_NAME_CARD = "NON_VALID_NAME";

    private Report report;

    @Before
    public void createReport(){
        report = FactoryReport.getTypeReport(FactoryReport.SIMPLE);
    }

    @Test
    public void getReportValidNameCardsTest(){
        final String regexValid = ""//
                + "INFORMATION ABOUT ALL CREATED CARDS:\\n{2}"//
                + "([[A-Z]\\s]*\\n"//
                + "(\\d{4}\\s?){4})*\\n"//
                + "Count of cards created - \\d";
        List<Card> cards = FactoryCard.getCards(Arrays.asList(allCards));

        assertTrue(Pattern.compile(regexValid).
                matcher(report.getReport(cards)).find());
    }

    @Test
    public void getReportNonValidNameCardsTest(){
        final String regexNonValid = ""//
                + "The next card names do not meet the requirements input: .+";

        System.out.println(report.getReportNonValidCardName(NON_VALID_NAME_CARD));

        assertTrue(Pattern.compile(regexNonValid).
                matcher(report.getReportNonValidCardName(NON_VALID_NAME_CARD)).find());
    }

    @After
    public void destroyReport(){
        report = null;
    }

}
