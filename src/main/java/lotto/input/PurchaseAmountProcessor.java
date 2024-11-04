package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import lotto.util.InputUtil;

public class PurchaseAmountProcessor {

    private static final int PURCHASE_UNIT = 1000;
    private static final int ZERO = 0;
    private static final long MAX_PURCHASE_AMOUNT = 1_000_000_000L;
    private static final String POSITIVE_SIGN = "+";

    private PurchaseAmountProcessor() {
    }

    public static int calculatePurchaseCount(String input) {
        int money = validateAndParse(input);

        if (money % PURCHASE_UNIT != ZERO) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }

        return money / PURCHASE_UNIT;
    }

    private static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);
        String trimmedInput = input.trim();
        if (trimmedInput.startsWith(POSITIVE_SIGN)) {
            throw new IllegalArgumentException(POSITIVE_SIGN_INPUT.getMessage());
        }
        InputUtil.validatePositiveInteger(input);

        long money = Long.parseLong(trimmedInput);
        if (money > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(EXCEEDS_MAX_AMOUNT.getMessageWithMaxAmount(MAX_PURCHASE_AMOUNT));
        }

        return Integer.parseInt(trimmedInput);
    }
}
