package lotto.exception;

import lotto.enums.LottoErrorMessage;

public class LottoException extends IllegalArgumentException {

    public LottoException(LottoErrorMessage lottoErrorMessage) {
        super(lottoErrorMessage.getMessage());
    }
}