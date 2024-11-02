package lotto.validator;

import lotto.constants.ErrorMessage;

public final class Validator {
    public static void validateMoneyInput(String moneyInput) {
        validateNotBlank(moneyInput);
        validateIsInteger(moneyInput);
        validateIsPositive(moneyInput);
        validateIsValidMoney(moneyInput);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    private static void validateIsPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    private static void validateIsValidMoney(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MONEY.getMessage());
        }
    }
}
