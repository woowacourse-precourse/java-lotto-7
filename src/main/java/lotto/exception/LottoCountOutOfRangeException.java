package lotto.exception;

import static lotto.constants.ExceptionMessages.LOTTO_COUNT_OUT_OF_RANGE;

public class LottoCountOutOfRangeException extends IllegalArgumentException {

    public LottoCountOutOfRangeException() {
        super(LOTTO_COUNT_OUT_OF_RANGE);
    }
}
