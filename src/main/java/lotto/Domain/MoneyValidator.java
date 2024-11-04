package lotto.Domain;

import lotto.Messages.ErrorMessages;

public class MoneyValidator {
    private static final int MONEY_UNIT = 1000;

    public static void validate(String input) {
        int amount = parseAmount(input);
        validateNegative(amount);
        validateUnit(amount);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.FORMAT_INVALID.message);
        }
    }

    private static void validateNegative(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NEGATIVE.message);
        }
    }

    private static void validateUnit(int amount) {
        if (amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNIT.message);
        }
    }
}

