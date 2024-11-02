package lotto;

import static lotto.ExceptionMessages.INVALID_AMOUNT;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public void validateAmount(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
    }
}
