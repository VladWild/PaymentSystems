package com.epam.paymentsystems.formatcard;

import com.epam.paymentsystems.cards.Card;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class StandardFormat implements Format {
    private static final Logger LOGGER = Logger.getLogger(StandardFormat.class);

    private static final String FORMAT_CARD = "%s%s";
    private static final String NAME = "%s%n";
    private static final String UNDERSCORE = "_";
    private static final String SPLIT = " ";

    private String getNameCard(Card card) {
        LOGGER.trace("Forming name of card");
        return String.format(NAME, Arrays.stream(card.getNameCard().split(UNDERSCORE))
                .reduce("", (accomulator, element) ->
                accomulator + element.toUpperCase() + SPLIT));
    }

    private String getNumber(int[] number) {
        LOGGER.trace("Forming number of card");
        StringBuilder formatNumber = new StringBuilder();

        for (int i = 0; i < number.length; i++) {
            if (i % 4 == 0 && i != 0) {
                formatNumber.append(SPLIT);
            }

            formatNumber.append(number[i]);
        }

        return formatNumber.toString();
    }

    @Override
    public String getFormat(Card card) {
        return String.format(FORMAT_CARD, getNameCard(card), getNumber(card.getNumber()));
    }
}
