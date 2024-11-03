package lotto.exception.lotto;

import lotto.util.ErrorMessage;

public class LottoNumberDuplicateException extends IllegalArgumentException {
    public LottoNumberDuplicateException() {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE);
    }
}
