package lotto.validator;

import static lotto.constant.ExceptionMessage.INVALID_COMMON_EMPTY;

public class CommonInputValidator {

    public void validateEmpty(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_COMMON_EMPTY.getMessage());
        }
    }

}
