package lotto.exception;

import lotto.message.ErrorMessage;

public final class DuplicateLottoNumberException extends IllegalArgumentException {
    public DuplicateLottoNumberException() {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getErrorMessage());
    }
}
