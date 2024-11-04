package lotto.exception.argument.lotto;

import lotto.exception.base.CustomIllegalArgumentException;

public class InvalidLottoNumberException extends CustomIllegalArgumentException {

    public InvalidLottoNumberException(final String message) {
        super(message);
    }
}
