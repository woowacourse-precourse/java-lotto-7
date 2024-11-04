package lotto.exception;

import static lotto.exception.message.ErrorMessage.ERROR_PREFIX;
import lotto.exception.message.ParserExceptionMessage;

public class ParserException extends IllegalArgumentException {
    public ParserException(ParserExceptionMessage errorMessage) {
        super(ERROR_PREFIX + errorMessage.getMessage());
    }
}