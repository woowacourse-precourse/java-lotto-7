package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessage;

public class PurchaseAmount {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int MAX_AMOUNT = 100000;

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validateExceedAmount(purchaseAmount);
        validateDivisibleAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int calculateQuantity() {
        return this.purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private void validateExceedAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    private void validateDivisibleAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_PRICE || purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseAmount that = (PurchaseAmount) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
