package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;

public record PurchasePrice(int value) {
    public PurchasePrice {
        validate(value);
    }

    private void validate(final int value) {
        validateIsPositive(value);
        validateIsPurchaseUnit(value);
    }

    private void validateIsPositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_NON_POSITIVE_AMOUNT.getMessage());
        }
    }

    private void validateIsPurchaseUnit(final int value) {
        if (value % Rule.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    public int calculateQuantity() {
        return value / Rule.LOTTO_PRICE;
    }
}
