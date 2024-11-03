package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import lotto.util.InputUtil;

public class PurchaseAmountProcessor {

    private static final int PURCHASE_UNIT = 1000;
    private static final String POSITIVE_SIGN = "+";
    private static final String NUMERIC_REGEX = "\\d+";

    private PurchaseAmountProcessor() {
    }

    public static int calculatePurchaseCount(String input) {
        int money = validateAndParse(input);

        if (money % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }

        return money / 1000;
    }

    private static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);
        String trimmedInput = input.trim();
        InputUtil.validatePositiveInteger(trimmedInput);
        if (trimmedInput.startsWith(POSITIVE_SIGN)) {
            throw new IllegalArgumentException(POSITIVE_SIGN_INPUT.getMessage());
        }
        if (!trimmedInput.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }

        return Integer.parseInt(trimmedInput);
    }
}
