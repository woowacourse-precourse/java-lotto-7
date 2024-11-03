package lotto.exception.lotto;

import lotto.util.ErrorMessage;

public class LottoInputFormatException extends IllegalArgumentException {
    public LottoInputFormatException() {
        super(ErrorMessage.LOTTO_NUMBER_FORMAT);
    }
}
