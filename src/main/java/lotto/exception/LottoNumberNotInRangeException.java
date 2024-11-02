package lotto.exception;

import lotto.message.ErrorMessage;

public final class LottoNumberNotInRangeException extends IllegalArgumentException {
    public LottoNumberNotInRangeException() {
        super(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getErrorMessage());
    }
}
