package lotto.exception;

import lotto.util.ErrorMessage;

public class InputNumberFormatException extends IllegalArgumentException {
    public InputNumberFormatException() {
        super(ErrorMessage.INPUT_NUMBER_FORMAT);
    }
}
