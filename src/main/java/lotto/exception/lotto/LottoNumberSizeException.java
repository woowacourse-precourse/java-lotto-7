package lotto.exception.lotto;

import lotto.util.ErrorMessage;

public class LottoNumberSizeException extends IllegalArgumentException {
    public LottoNumberSizeException() {
        super(ErrorMessage.LOTTO_NUMBER_SIZE);
    }
}
