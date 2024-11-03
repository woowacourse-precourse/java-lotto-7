package lotto.io.exception;

import static lotto.io.error.ErrorMessage.HAS_SMALL_CHANGE;

public class SmallChangeException extends IllegalArgumentException {

    private SmallChangeException(final String message) {
        super(message);
    }

    public static SmallChangeException invalidUnit() {
        throw new SmallChangeException(HAS_SMALL_CHANGE);
    }
}
