package lotto.model;

import lotto.exception.InvalidPurchaseAmountException;

import static lotto.exception.ErrorMessage.INVALID_COUNT_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_PRICE_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_SIZE_OF_PURCHASE;

public class Purchase {
    private static final int ONE_TICKET_PRICE = 1000;
    private static final int MAX_TICKET_PRICE = 100000;

    private final int purchasePrice;
    private final int purchaseCount;

    public Purchase(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchasePrice / ONE_TICKET_PRICE;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    private void validate(int purchasePrice) {
        checkPriceLessThanMaxTicketPrice(purchasePrice);
        checkPriceLessThanZero(purchasePrice);
        checkPriceDivisibleByOneTicketPrice(purchasePrice);
    }

    private void checkPriceLessThanMaxTicketPrice(int purchasePrice) {
        if (purchasePrice > MAX_TICKET_PRICE) {
            throw new InvalidPurchaseAmountException(INVALID_COUNT_OF_PURCHASE.getMessage());
        }
    }

    private void checkPriceLessThanZero(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new InvalidPurchaseAmountException(INVALID_SIZE_OF_PURCHASE.getMessage());
        }
    }

    private void checkPriceDivisibleByOneTicketPrice(int purchasePrice) {
        if (purchasePrice % ONE_TICKET_PRICE != 0) {
            throw new InvalidPurchaseAmountException(INVALID_PRICE_OF_PURCHASE.getMessage());
        }
    }
}
