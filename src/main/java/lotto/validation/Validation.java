package lotto.validation;

import lotto.error.ErrorStatus;

public class Validation {
    private static final int LOTTO_PRICE = 1000;

    public static void validateMoneyAmount(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }
}
