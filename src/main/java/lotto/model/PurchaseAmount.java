package lotto.model;

import lotto.exception.ErrorCode;

public class PurchaseAmount {
    private static final int MIN_PURCHASE_AMOUNT = 0;

    private final int value;

    public PurchaseAmount(String purchaseAmount) {
        this.value = parseInput(purchaseAmount);
        validate(value);
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private void validate(int value) {
        validateUnits(value);
        validateNegative(value);
    }

    private void validateUnits(int value) {
        if (value % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_IN_UNITS_OF_THOUSAND.getMessage());
        }
    }

    private void validateNegative(int value) {
        if (value < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    public String calculatePurchaseLottoCount() {
        return String.valueOf(value / Lotto.PRICE);
    }
}
