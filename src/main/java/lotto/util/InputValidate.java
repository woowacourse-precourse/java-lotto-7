package lotto.util;

public class InputValidate {
    public void bonusRangeValidate(String input) {
        blankValidate(input);
        isDigitValidate(input);
        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(Error.LOTTO_RANGE_ERROR.message());
        }
    }

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
