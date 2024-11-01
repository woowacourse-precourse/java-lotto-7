package lotto.exception;

import lotto.constant.LottoErrorMessages;

public class NumberOutOfRangeException extends LottoException {
    public NumberOutOfRangeException() {
        super(LottoErrorMessages.NUMBER_OUT_OF_RANGE.getMessage());
    }
}
