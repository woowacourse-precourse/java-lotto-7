package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.INVALID_WINNING_NUMBER_FORMAT;

public class InvalidWinningNumberFormatException extends LottoException {

    public InvalidWinningNumberFormatException() {
        super(INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }
}
