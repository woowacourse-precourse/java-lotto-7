package lotto.exception.winning;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {
    public LottoNumberOutOfRangeException() {
        super(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }
}
