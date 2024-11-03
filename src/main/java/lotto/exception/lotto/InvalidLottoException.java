package lotto.exception.lotto;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidLottoException extends CustomIllegalArgumentException {

    public InvalidLottoException(final String message) {
        super(message);
    }
}
