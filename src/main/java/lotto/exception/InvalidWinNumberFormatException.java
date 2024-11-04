package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidWinNumberFormatException extends IllegalArgumentException {
    public InvalidWinNumberFormatException() {
        super(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
    }
}
