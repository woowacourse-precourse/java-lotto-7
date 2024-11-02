package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessage;

public class PurchaseAmount {

    private static final int STANDARD_AMOUNT_UNIT = 1000;
    private static final int MAX_AMOUNT = 100000;

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int calculateQuantity() {
        return this.purchaseAmount / STANDARD_AMOUNT_UNIT;
    }

    private void validate(int purchaseAmount) {
        validateExceedAmount(purchaseAmount);
        validateDivisibleAmount(purchaseAmount);
    }

    private void validateExceedAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    private void validateDivisibleAmount(int purchaseAmount) {
        if (purchaseAmount < STANDARD_AMOUNT_UNIT || purchaseAmount % STANDARD_AMOUNT_UNIT != 0) {
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
