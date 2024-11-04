package lotto.validator;

import lotto.exception.ErrorMessage;

public class MoneyValidator {
    private static final int LOTTO_PRICE = 1000;

    public static void validate(String input) {
        try {
            int money = Integer.parseInt(input.trim());
            if (money % LOTTO_PRICE != 0) {
                printErrorAndRetry(ErrorMessage.INVALID_MONEY_AMOUNT.getMessage());
            }
        } catch (NumberFormatException e) {
            printErrorAndRetry(ErrorMessage.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    private static void printErrorAndRetry(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
        throw new IllegalArgumentException("[ERROR] " + errorMessage);
    }
}
