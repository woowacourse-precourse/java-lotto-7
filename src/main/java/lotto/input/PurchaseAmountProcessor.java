package lotto.input;

import static lotto.exception.ExceptionMessage.*;

public class PurchaseAmountProcessor {

    private PurchaseAmountProcessor() {
    }

    public static int calculatePurchaseCount(String input) {
        int money = validateAndParse(input);
        System.out.println(money);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
        return money / 1000;
    }

    private static int validateAndParse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
        if (input.contains(".") || input.trim().startsWith("-") || "0".equals(input.trim())) {
            throw new IllegalArgumentException(NEGATIVE_OR_ZERO__INPUT.getMessage());
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }
        return Integer.parseInt(input);
    }

}
