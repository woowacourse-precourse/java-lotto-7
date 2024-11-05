package lotto.exception;

import static lotto.constants.ExceptionMessages.LOTTO_NUMBER_COUNT_OUT_OF_RANGE;

public class LottoNumberCountOutOfRangeException extends IllegalArgumentException {
    public LottoNumberCountOutOfRangeException() {
        super(LOTTO_NUMBER_COUNT_OUT_OF_RANGE);
    }
}
