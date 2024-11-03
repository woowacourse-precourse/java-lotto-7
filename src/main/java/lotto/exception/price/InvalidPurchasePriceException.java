package lotto.exception.price;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidPurchasePriceException extends CustomIllegalArgumentException {

    public InvalidPurchasePriceException(final String s) {
        super(s);
    }
}
