package lotto.io.request;

import lotto.util.ExceptionMessages;

public record NumberRequest(String number) {

    private static final String NUMBER_PATTERN = "\\d+";

    public NumberRequest {
        validateEmpty(number);
        validateNumber(number);
    }

    private void validateEmpty(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER.getMessage());
        }
    }
}
