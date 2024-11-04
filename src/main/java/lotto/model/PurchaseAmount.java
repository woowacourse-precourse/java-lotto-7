package lotto.model;

import lotto.exception.ErrorCode;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(String purchaseAmount) {
        int value = parseInput(purchaseAmount);
        validateValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private void validateValue(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NOT_IN_UNITS_OF_THOUSAND.getMessage());
        }

        if (value < 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    public String calculatePurchaseLottoCount() {
        return String.valueOf(value / 1000);
    }
}
