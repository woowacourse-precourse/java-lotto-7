package lotto.exception;

import static lotto.constant.LottoErrorMessages.INVALID_LOTTO_SIZE;

public class InvalidLottoSizeException extends LottoException {
    public InvalidLottoSizeException() {
        super(INVALID_LOTTO_SIZE);
    }
}
