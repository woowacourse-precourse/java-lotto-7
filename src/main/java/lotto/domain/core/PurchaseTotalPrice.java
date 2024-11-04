package lotto.domain.core;

import static lotto.exception.ErrorMessage.*;

import lotto.utils.parser.PurchaseTotalPriceParser;

public record PurchaseTotalPrice(int totalPrice) {
    private static final int MAX_LIMIT = 100_000_000;
    private static final int UNIT_PRICE = 1000;

    public static PurchaseTotalPrice from(String input) {
        int parsedTotalPrice = PurchaseTotalPriceParser.parse(input);
        validate(parsedTotalPrice);
        return new PurchaseTotalPrice(parsedTotalPrice);
    }

    private static void validate(int totalPrice) {
        validateNegativeTotalPrice(totalPrice);
        validateZeroTotalPrice(totalPrice);
        validateTotalPriceWithinLimit(totalPrice);
        validateTotalPriceMultipleOfUnit(totalPrice);
    }

    private static void validateNegativeTotalPrice(int totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException(NOT_NEGATIVE.getMessage());
        }
    }

    private static void validateZeroTotalPrice(int totalPrice) {
        if (totalPrice == 0) {
            throw new IllegalArgumentException(NOT_ZERO.getMessage());
        }
    }

    private static void validateTotalPriceWithinLimit(int totalPrice) {
        if (totalPrice > MAX_LIMIT) {
            throw new IllegalArgumentException(EXCEEDS_LIMIT.getMessage());
        }
    }

    private static void validateTotalPriceMultipleOfUnit(int totalPrice) {
        if (totalPrice % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
