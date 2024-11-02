package lotto.domain;

import static lotto.exception.ErrorMessage.*;
import lotto.exception.CustomIllegalArgumentException;

public class TicketCountCalculator {
    private static final int TICKET_PRICE = 1000;

    public int getTicketCount(PurchaseTotalPrice purchaseTotalPrice) {
        int totalPrice = purchaseTotalPrice.totalPrice();
        int ticketCount = calculateTickets(totalPrice);
        validateTicketCount(ticketCount, totalPrice);
        return ticketCount;
    }

    private int calculateTickets(int totalPrice) {
        return totalPrice / TICKET_PRICE;
    }

    private void validateTicketCount(int ticketCount, int totalPrice) {
        int expectedTicketCount = totalPrice / TICKET_PRICE;
        if (ticketCount != expectedTicketCount) {
            throw CustomIllegalArgumentException.from(INVALID_TICKET_COUNT);
        }
    }
}
