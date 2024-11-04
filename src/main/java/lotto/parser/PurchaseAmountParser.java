package lotto.parser;

import static lotto.constants.ErrorMessages.*;

public class PurchaseAmountParser {

    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NUMERIC);
        }
    }
}