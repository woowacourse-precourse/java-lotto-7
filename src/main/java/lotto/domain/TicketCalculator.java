package lotto.domain;

import lotto.util.ErrorMessages;

public class TicketCalculator {
    private static final int TICKET_PRICE = 1000;

    public static int calculateTicketCount(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT.getMessage());
        }
        return purchaseAmount / TICKET_PRICE;
    }
}