package lotto.exception;

import lotto.message.ExceptionMessage;

public class MoneyException extends IllegalArgumentException {

    public MoneyException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
