package lotto.exception.argument.converter;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidConvertException extends CustomIllegalArgumentException {

    public InvalidConvertException(final String message) {
        super(message);
    }
}
