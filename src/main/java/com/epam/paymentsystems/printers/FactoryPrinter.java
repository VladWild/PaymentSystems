package com.epam.paymentsystems.printers;

public enum FactoryPrinter {
    CONSOLE {
        @Override
        protected Printer getPrinter() {
            return new ConsolePrinter();
        }
    }, FILE {
        @Override
        protected Printer getPrinter() {
            return new FilePrinter();
        }
    };

    protected abstract Printer getPrinter();

    public static Printer getTypePrinter(FactoryPrinter printerType){
        return printerType.getPrinter();
    }

}

