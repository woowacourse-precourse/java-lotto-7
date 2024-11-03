package lotto.domain;

import static lotto.exception.ErrorMessage.MINIMUM_TICKET_PURCHASE_ERROR;
import static lotto.exception.ErrorMessage.PURCHASE_PRICE_DIVIDE_ERROR;

public class Ticket {

    private static final int TICKET_PRICE = 1_000;
    private int quantity;
    private int purchaseAmount;
    private Ticket(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        quantity = purchaseAmount / TICKET_PRICE;
    }

    public static Ticket from(int purchaseAmount) {
        return new Ticket(purchaseAmount);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        validateMinimumPurchaseAmount(purchaseAmount);
        validateDividePurchaseAmount(purchaseAmount);
    }

    private void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException(MINIMUM_TICKET_PURCHASE_ERROR.getMessage());
        }
    }

    private void validateDividePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_DIVIDE_ERROR.getMessage());
        }
    }

}
