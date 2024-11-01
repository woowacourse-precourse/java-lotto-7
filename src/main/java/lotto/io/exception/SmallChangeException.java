package lotto.io.exception;

import static lotto.io.error.ErrorMessage.HAS_SMALL_CHANGE;

public class SmallChangeException extends IllegalArgumentException {

    private SmallChangeException(final String s) {
        super(s);
    }

    public static SmallChangeException invalidUnit() {
        throw new SmallChangeException(HAS_SMALL_CHANGE);
    }
}
