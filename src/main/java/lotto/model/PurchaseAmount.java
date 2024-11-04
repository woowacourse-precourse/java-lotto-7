package lotto.model;

import lotto.exception.ErrorCode;
import lotto.model.lotto.Lotto;

public class PurchaseAmount {
    private static final int MIN_PURCHASE_AMOUNT = 0;

    private final int value;

    public PurchaseAmount(String purchaseAmount) {
        this.value = parseInput(purchaseAmount);
        validate(value);
    }

    public String calculatePurchaseLottoCount() {
        return String.valueOf(value / Lotto.PRICE);
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private void validate(int value) {
        validatePurchaseAmountBounds(value);
        validateUnits(value);
    }

    private void validatePurchaseAmountBounds(int value) {
        if (value <= MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateUnits(int value) {
        if (value % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_IN_UNITS_OF_THOUSAND.getMessage());
        }
    }
}
