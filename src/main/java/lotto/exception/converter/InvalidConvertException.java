package lotto.exception.converter;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidConvertException extends CustomIllegalArgumentException {

    public InvalidConvertException(final String message) {
        super(message);
    }
}
