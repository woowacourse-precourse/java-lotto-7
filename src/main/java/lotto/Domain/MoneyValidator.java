package lotto.Domain;

import lotto.Messages.ErrorMessages;

public class MoneyValidator {
    private static final int MONEY_UNIT = 1000;

    public static void validate(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.FORMAT_INVALID.message);
        }
        validateAmount(Integer.parseInt(input));
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.MONEY_NEGATIVE.message);
        }
        if (amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.MONEY_UNIT.message);
        }
    }
}