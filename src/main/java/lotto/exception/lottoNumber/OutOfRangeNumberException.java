package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.OUT_OF_RANGE_NUMBER_MESSAGE;

public class OutOfRangeNumberException extends IllegalArgumentException {
    public OutOfRangeNumberException() {
        super(OUT_OF_RANGE_NUMBER_MESSAGE);
    }
}
