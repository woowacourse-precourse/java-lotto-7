package lotto.exception.lotto;

import lotto.exception.CustomIllegalArgumentException;

public class InvalidLottoNumberException extends CustomIllegalArgumentException {

    public InvalidLottoNumberException(final String message) {
        super(message);
    }
}
