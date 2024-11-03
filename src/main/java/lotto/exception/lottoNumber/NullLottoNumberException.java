package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.NULL_LOTTO_NUMBERS_MESSAGE;

public class NullLottoNumberException extends IllegalArgumentException {
    public NullLottoNumberException() {
        super(NULL_LOTTO_NUMBERS_MESSAGE);
    }
}
