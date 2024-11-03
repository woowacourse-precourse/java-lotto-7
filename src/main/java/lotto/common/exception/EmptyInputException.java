package lotto.common.exception;

import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super(EMPTY_INPUT.getMessages());
    }
}
