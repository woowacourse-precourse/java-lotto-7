package lotto.exception.base;

import static lotto.exception.constants.ExceptionMessage.ERROR_PREFIX;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException(final String message) {
        super(ERROR_PREFIX.format(message));
    }
}
