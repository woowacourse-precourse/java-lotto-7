package lotto.validator;

import lotto.common.ErrorMessage;

public class BasicNumberValidator implements NumberValidator {

    private static final String NUMBER_PATTERN = "\\d+";

    @Override
    public int validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY.getMessage());
        }

        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        return Integer.parseInt(input);
    }
}
