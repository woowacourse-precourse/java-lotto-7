package lotto.model;

import lotto.exception.InvalidPurchaseAmountException;

import static lotto.exception.ErrorMessage.INVALID_COUNT_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_PRICE_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_SIZE_OF_PURCHASE;

public class PurchasePrice {
    private static final int ONE_TICKET_PRICE = 1000;
    private static final int MAX_TICKET_PRICE = 100000;

    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int get() {
        return purchasePrice;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % ONE_TICKET_PRICE != 0) {
            throw new InvalidPurchaseAmountException(INVALID_PRICE_OF_PURCHASE.getMessage());
        }

        if (purchasePrice > MAX_TICKET_PRICE) {
            throw new InvalidPurchaseAmountException(INVALID_COUNT_OF_PURCHASE.getMessage());
        }

        if (purchasePrice <= 0) {
            throw new InvalidPurchaseAmountException(INVALID_SIZE_OF_PURCHASE.getMessage());
        }
    }
}
