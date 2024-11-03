package lotto.config.exception.lotto;

import lotto.config.exception.GlobalException;

public class LottoException extends GlobalException {
    public LottoException(LottoExceptionMessage message) {
        super(message.getMessage());
    }
}
