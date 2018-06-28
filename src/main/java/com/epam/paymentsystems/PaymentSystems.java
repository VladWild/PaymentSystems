package com.epam.paymentsystems;

import com.epam.paymentsystems.cards.Card;
import com.epam.paymentsystems.cards.FactoryCard;
import com.epam.paymentsystems.printers.FactoryPrinter;
import com.epam.paymentsystems.printers.Printer;
import com.epam.paymentsystems.reports.FactoryReport;
import com.epam.paymentsystems.reports.Report;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PaymentSystems {
    private static final Logger LOGGER = Logger.getLogger(PaymentSystems.class);

    private static final int COUNT_DIGITS_CARD = 24;

    private static final Printer printer = FactoryPrinter.
            getTypePrinter(FactoryPrinter.CONSOLE);
    private static final Report report = FactoryReport.
            getTypeReport(FactoryReport.SIMPLE);

    private String[] cards;

    private PaymentSystems(String[] cards) {
        this.cards = cards;
    }

    private void run() throws IOException, IllegalArgumentException {
        LOGGER.info("Creation of all required cards");
        List<Card> cards = FactoryCard.getCards(Arrays.asList(this.cards), COUNT_DIGITS_CARD);

        LOGGER.info("Printing report");
        printer.print(report.getReport(cards));
    }

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("src/main/resources/log4j.xml");

        LOGGER.info("Application \"Payment Systems\" is start");

        PaymentSystems paymentSystems = new PaymentSystems(args);
        try {
            LOGGER.debug("Application \"Payment Systems\" is run");
            paymentSystems.run();
        } catch (IOException e) {
            LOGGER.error("The output file is not found. Exception: " + e.toString());
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            String nonValidNameCard = e.toString().split("\\.")
                    [e.toString().split("\\.").length - 1];
            LOGGER.error("The next name card is not validate: " + nonValidNameCard +
                    ". Exception: " + e.toString());
            printer.print(report.getReportNonValidCardName(nonValidNameCard));
            e.printStackTrace();
        }
    }
}

