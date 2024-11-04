package lotto.Domain;

import lotto.Messages.ErrorMessages;

public class MoneyValidator {
    private static final int MONEY_UNIT = 1000;

    public static void validate(String input) {
        int amount = Integer.parseInt(input);
        validateAmount(amount);
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NEGATIVE.message);
        }
        if (amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNIT.message);
        }
    }
}