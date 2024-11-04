package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.INVALID_LOTTO_COUNT_MESSAGE;

public class InvalidLottoCountException extends IllegalArgumentException {
    public InvalidLottoCountException() {
        super(INVALID_LOTTO_COUNT_MESSAGE);
    }
}
