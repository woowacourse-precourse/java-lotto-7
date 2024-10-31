package lotto.view;

import lotto.model.ErrorMessage;

public class SimpleInputValidator {

    private static final String NUMBERS_WITH_COMMA_PATTERN = "^\\d+(\\s*,\\s*\\d+)*$";
    private static final String NUMBER_ONLY_PATTERN = "^\\d+$";

    public void validateWinningNumber(String input) {
        if (!input.matches(NUMBERS_WITH_COMMA_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    public void isNumber(String input) {
        if (!input.matches(NUMBER_ONLY_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
