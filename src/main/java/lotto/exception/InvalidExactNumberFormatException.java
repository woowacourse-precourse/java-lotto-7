package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidExactNumberFormatException extends IllegalArgumentException {
    public InvalidExactNumberFormatException() {
        super(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
    }
}
