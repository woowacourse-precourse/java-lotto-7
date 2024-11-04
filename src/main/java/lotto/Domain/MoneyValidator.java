package lotto.Domain;

import lotto.Messages.ErrorMessages;

public class MoneyValidator {
    private static final int MONEY_UNIT = 1000;

    public static void validate(String input) {
        validateNumber(input);
        int amount = Integer.parseInt(input);
        validatePositive(amount);
        validateUnit(amount);
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.FORMAT_INVALID.message);
        }
    }

    private static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.MONEY_NEGATIVE.message);
        }
    }

    private static void validateUnit(int amount) {
        if (amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.MONEY_UNIT.message);
        }
    }
}