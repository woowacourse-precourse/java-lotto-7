package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.DUPLICATE_WINNING_NUMBER;

public class DuplicateWinningNumber extends LottoException {

    public DuplicateWinningNumber() {
        super(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}
