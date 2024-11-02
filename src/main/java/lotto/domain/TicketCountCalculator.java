package lotto.domain;

import static lotto.exception.ErrorMessage.*;
import lotto.exception.CustomIllegalArgumentException;

public class TicketCountCalculator {
    private static final int TICKET_PRICE = 1000;

    public int getTicketCount(PurchaseTotalPrice purchaseTotalPrice) {
        int totalAmount = purchaseTotalPrice.amount();
        int ticketCount = calculateTickets(totalAmount);
        validateTicketCount(ticketCount, totalAmount);
        return ticketCount;
    }

    private int calculateTickets(int totalAmount) {
        return totalAmount / TICKET_PRICE;
    }

    private void validateTicketCount(int ticketCount, int totalAmount) {
        int expectedTicketCount = totalAmount / TICKET_PRICE;
        if (ticketCount != expectedTicketCount) {
            throw CustomIllegalArgumentException.from(INVALID_TICKET_COUNT);
        }
    }
}
