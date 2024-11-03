package lotto.exception.quantity;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidQuantityException extends CustomIllegalArgumentException {

    public InvalidQuantityException(final String s) {
        super(s);
    }
}
