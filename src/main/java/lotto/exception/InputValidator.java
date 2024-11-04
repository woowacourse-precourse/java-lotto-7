package lotto.exception;

public class InputValidator {
    private static final String BLANK = " ";

    public static void validateContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK.getErrorMessage());
        }
    }
}
