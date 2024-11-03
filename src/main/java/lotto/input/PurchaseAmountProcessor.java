package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import lotto.util.InputUtil;

public class PurchaseAmountProcessor {

    private static final int PURCHASE_UNIT = 1000;
    private static final String POSITIVE_SIGN = "+";

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
        if (trimmedInput.startsWith(POSITIVE_SIGN)) {
            throw new IllegalArgumentException(POSITIVE_SIGN_INPUT.getMessage());
        }
        InputUtil.validatePositiveInteger(input);
        return Integer.parseInt(trimmedInput);
    }
}
