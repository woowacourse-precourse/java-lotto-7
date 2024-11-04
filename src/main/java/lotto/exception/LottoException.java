package lotto.exception;

import lotto.message.ErrorMessage;

public class LottoException extends Exception {
    public LottoException(ErrorMessage message) {
        super(message.getMessage());
    }
}