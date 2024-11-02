package lotto;

import static lotto.ExceptionMessages.INVALID_INPUT;

public class InputValidator {
    private static final String DELIMITER = ",";

    public void validateAmount(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
