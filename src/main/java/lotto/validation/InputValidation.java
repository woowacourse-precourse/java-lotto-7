package lotto.validation;

import lotto.exception.BlankMessageException;

public final class InputValidation {
    public static void isNotBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new BlankMessageException();
        }
    }
}
