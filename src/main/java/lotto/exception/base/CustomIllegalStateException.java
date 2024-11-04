package lotto.exception.base;

import static lotto.exception.constants.ExceptionMessage.ERROR_PREFIX;

public class CustomIllegalStateException extends IllegalStateException {

    public CustomIllegalStateException(final String message) {
        super(ERROR_PREFIX.format(message));
    }
}
