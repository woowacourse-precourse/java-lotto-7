package lotto.domain.core;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;
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
            throw CustomIllegalArgumentException.from(NOT_NEGATIVE);
        }
    }

    private static void validateZeroTotalPrice(int totalPrice) {
        if (totalPrice == 0) {
            throw CustomIllegalArgumentException.from(NOT_ZERO);
        }
    }

    private static void validateTotalPriceWithinLimit(int totalPrice) {
        if (totalPrice > MAX_LIMIT) {
            throw CustomIllegalArgumentException.from(EXCEEDS_LIMIT);
        }
    }

    private static void validateTotalPriceMultipleOfUnit(int totalPrice) {
        if (totalPrice % UNIT_PRICE != 0) {
            throw CustomIllegalArgumentException.from(NOT_MULTIPLE_OF_UNIT);
        }
    }
}