package lotto.exception.argument.quantity;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidQuantityException extends CustomIllegalArgumentException {

    public InvalidQuantityException(final String s) {
        super(s);
    }
}
