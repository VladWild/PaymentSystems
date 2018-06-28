package com.epam.paymentsystems.reports;

public enum FactoryReport {
    SIMPLE {
        @Override
        protected Report getReport() {
            return new SimpleReport();
        }
    };

    protected abstract Report getReport();

    public static Report getTypeReport(FactoryReport typeReport){
        return typeReport.getReport();
    }
}
