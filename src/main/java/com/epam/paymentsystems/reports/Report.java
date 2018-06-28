package com.epam.paymentsystems.reports;

import com.epam.paymentsystems.cards.Card;

import java.util.List;

public interface Report {
    String getReport(List<Card> cards);
    String getReportNonValidCardName(String nonValidCardName);
}


