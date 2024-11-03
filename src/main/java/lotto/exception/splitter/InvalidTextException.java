package lotto.exception.splitter;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidTextException extends CustomIllegalArgumentException {

    public InvalidTextException(final String message) {
        super(message);
    }
}
