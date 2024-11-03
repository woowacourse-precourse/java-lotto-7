package lotto.validator;

import lotto.common.ErrorMessage;

public class BasicNumberValidator implements NumberValidator {

    @Override
    public int validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY.getMessage());
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
