package lotto.utils;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public class PurchaseTotalPriceParser {

    public static int parseTotalPriceFromString(String input) {
        return parseTotalPrice(input);
    }

    private static int parseTotalPrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw CustomIllegalArgumentException.from(NOT_INTEGER);
        }
    }
}
