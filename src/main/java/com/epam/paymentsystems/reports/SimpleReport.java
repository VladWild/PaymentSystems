package com.epam.paymentsystems.reports;

import com.epam.paymentsystems.cards.Card;
import org.apache.log4j.Logger;

import java.util.List;

public class SimpleReport implements Report{
    private static final Logger LOGGER = Logger.getLogger(SimpleReport.class);

    private static final String INFO = "INFORMATION ABOUT ALL CREATED CARDS:";
    private static final String RESULT = "Count of cards created - ";
    private static final String ENTER = "\n";
    private static final String ENTERS = "\n\n";
    private static final String NON_VALID_CARD_NAMES = "The next card names do not meet the requirements input: ";

    private String getInfoCard(List<Card> cards){
        return cards.stream().
                map(Card::toString).
                reduce("", (accomulator, element) ->
                        accomulator + element + ENTERS);
    }

    private String getNonValidCardNames(List<String> nonValidCardName){
        return nonValidCardName.stream().
                reduce("", (accomulator, element) ->
                        accomulator + ENTER + element);
    }

    @Override
    public String getReport(List<Card> cards) {
        LOGGER.debug("Creating report");
        StringBuilder report = new StringBuilder();

        LOGGER.debug("Begin of formatting report");
        report.append(INFO);
        report.append(ENTERS);
        report.append(getInfoCard(cards));
        report.append(RESULT);
        report.append(cards.size());

        LOGGER.debug("End of formatting report validate cards");

        return report.toString();
    }

    @Override
    public String getReportNonValidCardName(String nonValidCardNames) {
        return NON_VALID_CARD_NAMES + nonValidCardNames;
    }

}
