package com.epam.paymentsystems.printers;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FilePrinter implements Printer{
    private static final Logger LOGGER = Logger.getLogger(FilePrinter.class);

    private static final String PATH_FILE = "src\\main\\resources\\outputdata\\output";

    @Override
    public void print(String text) throws IOException {
        LOGGER.debug("Output text in file");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(PATH_FILE), StandardCharsets.UTF_8))) {
            writer.write(text.toCharArray());
        }
    }
}
