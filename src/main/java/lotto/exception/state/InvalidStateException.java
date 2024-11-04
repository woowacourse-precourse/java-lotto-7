package lotto.exception.state;

import lotto.exception.base.CustomIllegalStateException;

public class InvalidStateException extends CustomIllegalStateException {

    public InvalidStateException(final String message) {
        super(message);
    }
}
