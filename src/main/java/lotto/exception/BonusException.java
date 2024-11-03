package lotto.exception;

import lotto.message.ExceptionMessage;

public class BonusException extends IllegalArgumentException {

    public BonusException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
