package lotto.util;

public class Validator {
    public void validateEmptyInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
