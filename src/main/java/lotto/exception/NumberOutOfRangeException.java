package lotto.exception;

import static lotto.constant.LottoErrorMessages.NUMBER_OUT_OF_RANGE;

public class NumberOutOfRangeException extends LottoException {
    public NumberOutOfRangeException() {
        super(NUMBER_OUT_OF_RANGE);
    }
}
