package domain;

import static exception.ErrorMessage.PURCHASE_PRICE_DIVIDE_ERROR;

public class Ticket {

    private static final int TICKET_PRICE = 1_000;

    private int quantity;

    public Ticket(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        quantity = purchaseAmount / TICKET_PRICE;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_DIVIDE_ERROR.getMessage());
        }
    }

}
