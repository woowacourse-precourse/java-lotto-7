package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;
import lotto.utils.PurchaseAmountParser;

public record PurchaseTotalPrice(int amount) {
    private static final int MAX_LIMIT = 100_000_000;
    private static final int UNIT_PRICE = 1000;

    public static PurchaseTotalPrice from(String input) {
        int parsedAmount = PurchaseAmountParser.parseAmountFromString(input);
        validate(parsedAmount);
        return new PurchaseTotalPrice(parsedAmount);
    }

    private static void validate(int amount) {
        validateNegativeAmount(amount);
        validateZeroAmount(amount);
        validateWithinLimit(amount);
        validateMultipleOfUnit(amount);
    }

    private static void validateNegativeAmount(int amount) {
        if (amount < 0) {
            throw CustomIllegalArgumentException.from(NOT_NEGATIVE);
        }
    }

    private static void validateZeroAmount(int amount) {
        if (amount == 0) {
            throw CustomIllegalArgumentException.from(NOT_ZERO);
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
