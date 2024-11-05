package lotto.exception;

import static lotto.constants.ExceptionMessages.LOTTO_NUMBER_OUT_OF_RANGE;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {
    public LottoNumberOutOfRangeException() {
        super(LOTTO_NUMBER_OUT_OF_RANGE);
    }
}
