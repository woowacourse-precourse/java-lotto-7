package lotto.validation;

import lotto.exception.BlankMessageException;
import lotto.exception.InvalidNumberException;

public final class InputValidation {
    public static void isNotBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new BlankMessageException();
        }
    }

    public static int parseNumberValidation(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }
}
