package lotto.config.exception.input;

import lotto.config.exception.GlobalException;

public class InputException extends GlobalException {
    public InputException(InputExceptionMessage message) {
        super(message.getMessage());
    }
}
