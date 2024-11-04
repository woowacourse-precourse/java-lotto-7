package lotto.exception.argument.price;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidPriceException extends CustomIllegalArgumentException {

    public InvalidPriceException(final String s) {
        super(s);
    }
}
