package lotto.exception;

import lotto.constant.LottoErrorMessages;

public class InvalidLottoSizeException extends LottoException {
    public InvalidLottoSizeException() {
        super(LottoErrorMessages.INVALID_LOTTO_SIZE.getMessage());
    }
}
