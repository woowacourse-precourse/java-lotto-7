package lotto.View;

import lotto.Constants.Error;

public class InputView {
    private static final int MAX_CONSECUTIVE_ERROR = 5;
    int numConsecutiveErrors = 0;

    public void addNumConsecutiveError() {
        numConsecutiveErrors++;
        if (numConsecutiveErrors >= MAX_CONSECUTIVE_ERROR) {
            throw new TooManyErrorsException(Error.TOO_MANY_ERRORS.getText());
        }
    }

    static class TooManyErrorsException extends RuntimeException {
        public TooManyErrorsException(String message) {
            super(message);
        }
    }
}
