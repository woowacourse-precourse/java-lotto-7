package lotto.exception.argument.validator;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidInputException extends CustomIllegalArgumentException {

    public InvalidInputException(final String message) {
        super(message);
    }
}
