package lotto.domain.calculator;

import static lotto.exception.ErrorMessage.*;

import lotto.domain.core.PurchaseTotalPrice;
import lotto.dto.result.TicketCount;

public class TicketCountCalculator {
    private static final int TICKET_PRICE = 1000;

    public TicketCount calculateTotalTicketCount(PurchaseTotalPrice purchaseTotalPrice) {
        int totalPrice = purchaseTotalPrice.totalPrice();
        int ticketCount = divideTotalPriceByTicketPrice(totalPrice);
        validateTicketCount(ticketCount, totalPrice);
        return new TicketCount(ticketCount);
    }

    private int divideTotalPriceByTicketPrice(int totalPrice) {
        return totalPrice / TICKET_PRICE;
    }

    private void validateTicketCount(int ticketCount, int totalPrice) {
        int expectedTicketCount = totalPrice / TICKET_PRICE;
        if (ticketCount != expectedTicketCount) {
            throw new IllegalStateException(INVALID_TICKET_COUNT.getMessage());
        }
    }
}
