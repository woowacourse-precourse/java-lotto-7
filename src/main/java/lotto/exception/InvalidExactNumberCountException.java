package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidExactNumberCountException extends IllegalArgumentException {
    public InvalidExactNumberCountException() {
        super(LottoErrorMessage.LOTTO_WIN_NUMBER_COUNT_ERROR);
    }
}
