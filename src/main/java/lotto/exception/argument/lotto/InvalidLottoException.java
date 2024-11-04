package lotto.exception.argument.lotto;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidLottoException extends CustomIllegalArgumentException {

    public InvalidLottoException(final String message) {
        super(message);
    }
}
