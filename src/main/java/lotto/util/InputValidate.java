package lotto.util;

public class InputValidate {
    public void blankValidate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Error.INPUT_BLANK_ERROR.message());
        }
    }
}
