package lotto.exception;

import static lotto.error.ErrorMessage.AMOUNT_SHOULD_NOT_BE_MINUS;

public class ShouldNotBeMinusException extends IllegalArgumentException {
    private ShouldNotBeMinusException(final String message) {
        super(message);
    }

    public static ShouldNotBeMinusException minusMoney() {
        throw new ShouldNotBeMinusException(AMOUNT_SHOULD_NOT_BE_MINUS);
    }
}
