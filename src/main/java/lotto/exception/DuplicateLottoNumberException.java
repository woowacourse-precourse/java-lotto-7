package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    public DuplicateLottoNumberException() {
        super(LottoErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR);
    }
}
