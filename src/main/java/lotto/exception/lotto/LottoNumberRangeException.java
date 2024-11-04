package lotto.exception.lotto;

import lotto.util.ErrorMessage;

public class LottoNumberRangeException extends IllegalArgumentException {
    public LottoNumberRangeException() {
        super(ErrorMessage.LOTTO_NUMBER_RANGE);
    }
}
