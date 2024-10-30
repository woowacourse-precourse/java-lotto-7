package lotto.util;

import lotto.exception.ValidatorException;

public class InputValidator {

    private static final int LOTTO_PRICE = 1000;

    public static void run(String value) {
        validatePurchasePrice(value);
    }

    private static void validatePurchasePrice(String value) {
        ValidatorException.throwIfPurchasePriceIsBlank(value);
        ValidatorException.throwIfPurchasePriceIsNotNumber(value);
        ValidatorException.throwIfPurchasePriceNotMatchToUnit(value, LOTTO_PRICE);
    }



}
