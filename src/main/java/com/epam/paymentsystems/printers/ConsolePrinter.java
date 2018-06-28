package com.epam.paymentsystems.printers;

import org.apache.log4j.Logger;

import java.io.IOException;

public class ConsolePrinter implements Printer {
    private static final Logger LOGGER = Logger.getLogger(ConsolePrinter.class);

    @Override
    public void print(String text) {
        LOGGER.debug("Output text in console");
        System.out.println(text);
    }
}

