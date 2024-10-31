package lotto.util;

public class InputValidate {
    public void isDigitValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INPUT_DIGIT_ERROR.message());
        }
    }

    public void blankValidate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Error.INPUT_BLANK_ERROR.message());
        }
    }
}
