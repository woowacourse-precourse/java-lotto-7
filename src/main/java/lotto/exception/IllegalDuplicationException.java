package lotto.exception;

import static lotto.message.ExceptionMessage.INVALID_DUPLICATION_INPUT;

public class IllegalDuplicationException extends IllegalArgumentException {
    public IllegalDuplicationException(String input) {
        super(String.format(INVALID_DUPLICATION_INPUT.getMessage(), input));
    }
}
