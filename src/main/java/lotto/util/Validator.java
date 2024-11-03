package lotto.util;

public class Validator {
    public void validateEmptyInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public void validateNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }
    }
}
