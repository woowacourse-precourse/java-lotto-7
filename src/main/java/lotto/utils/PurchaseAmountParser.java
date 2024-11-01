package lotto.utils;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public class PurchaseAmountParser {

    public static int parseAmountFromString(String input) {
        return parseAmount(input);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw CustomIllegalArgumentException.from(NOT_INTEGER);
        }
    }
}
