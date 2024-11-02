package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import lotto.util.InputUtil;

public class PurchaseAmountProcessor {

    private PurchaseAmountProcessor() {
    }

    public static int calculatePurchaseCount(String input) {
        int money = validateAndParse(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }

        return money / 1000;
    }

    private static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);

        String trimmedInput = input.trim();

        if (trimmedInput.startsWith("+")) {
            throw new IllegalArgumentException(POSITIVE_SIGN_INPUT.getMessage());
        }
        if (trimmedInput.startsWith("-") || "0".equals(trimmedInput) || trimmedInput.contains(".")) {
            throw new IllegalArgumentException(ONLY_POSITIVE_INPUT.getMessage());
        }
        if (!trimmedInput.matches("\\d+")) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }

        return Integer.parseInt(trimmedInput);
    }


}
