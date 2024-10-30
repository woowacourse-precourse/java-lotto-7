package lotto.exception;

import lotto.enums.ErrorCause;

public class ValidatorException {

    public static void throwIfPurchasePriceIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceIsNotNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceNotMatchToUnit(String value, int lottoPrice) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_UNIT.getMessage() + "(로또 1장: " + lottoPrice + "원)"
            );
        }
    }

    public static void throwIfPurchasePriceIsZeroOrNegative(String value) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_CANNOT_BE_ZERO_OR_NEGATIVE.getMessage());
        }
    }
}
