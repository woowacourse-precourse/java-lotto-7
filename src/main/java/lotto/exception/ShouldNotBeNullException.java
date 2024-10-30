package lotto.exception;

import static lotto.error.ErrorMessage.SHOULD_NOT_BE_NULL;

public class ShouldNotBeNullException extends NullPointerException {

    private ShouldNotBeNullException(final String message) {
        super(message);
    }

    public static ShouldNotBeNullException nullArgument() {
        return new ShouldNotBeNullException(SHOULD_NOT_BE_NULL);
    }
}
