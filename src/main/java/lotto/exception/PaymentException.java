package lotto.exception;

import static lotto.exception.message.ErrorMessage.ERROR_PREFIX;
import lotto.exception.message.PaymentExceptionMessage;

public class PaymentException extends IllegalArgumentException{
    public PaymentException(PaymentExceptionMessage errorMessage) {
        super(ERROR_PREFIX + errorMessage.getMessage());
    }
}