package lotto.domain;

import lotto.util.ErrorMessage;

public class Purchase {
    private final int priceAmount;
    private final int ticketCount;

    public Purchase(int priceAmount) {
        validatePriceAmountThousandMultiple(priceAmount);
        validatePriceAmountUnderHundredThousand(priceAmount);
        this.priceAmount = priceAmount;
        this.ticketCount = priceAmount / 1000;
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private void validatePriceAmountThousandMultiple(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_THOUSAND_MULTIPLE_ERROR.getMessage());
        }
    }

    private void validatePriceAmountUnderHundredThousand(int amount) {
        if (amount > 100000) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PURCHASE_MORE_HUNDRED_THOUSAND_ERROR.getMessage());
        }
    }
}
