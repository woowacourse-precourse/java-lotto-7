package lotto.domain;

import lotto.constant.Constant;
import lotto.exception.ErrorMessage;

public class Amount {
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount of(String input) {
        validate(input);
        return new Amount(Integer.parseInt(input));
    }

    private static void validate(String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches(Constant.NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateRange(String input) {
        int amount = parseInt(input);
        validateNegativeNumber(amount);
        validateUnderMinAmount(amount);
        validateUnit(amount);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TOO_BIG_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateNegativeNumber(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateUnderMinAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateUnit(int amount) {
        if (amount % Constant.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
