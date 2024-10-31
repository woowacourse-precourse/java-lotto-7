package lotto.dto;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public record PurchaseAmount(int amount) {

    private static final int MAX_LIMIT = 100_000_000;
    private static final int UNIT_PRICE = 1000;

    public static PurchaseAmount from(String input) {
        int parsedAmount = parseAmount(input);
        return new PurchaseAmount(parsedAmount);
    }

    private static int parseAmount(String input) {
        validateIsNumeric(input);
        int amount = Integer.parseInt(input);
        validateParsedAmount(amount);
        return amount;
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw CustomIllegalArgumentException.from(NOT_NUMERIC);
        }
    }

    private static void validateParsedAmount(int amount) {
        validatePositiveAmount(amount);
        validateWithinLimit(amount);
        validateMultipleOfUnit(amount);
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw CustomIllegalArgumentException.from(NOT_POSITIVE);
        }
    }

    private static void validateWithinLimit(int amount) {
        if (amount > MAX_LIMIT) {
            throw CustomIllegalArgumentException.from(EXCEEDS_LIMIT);
        }
    }

    private static void validateMultipleOfUnit(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw CustomIllegalArgumentException.from(NOT_MULTIPLE_OF_UNIT);
        }
    }
}
