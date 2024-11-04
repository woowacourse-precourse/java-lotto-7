package lotto.io.exception;

import static lotto.io.error.ErrorMessage.ALREADY_PICKED_NUMBER;

public class AlreadyPickedNumberException extends IllegalArgumentException {

    public AlreadyPickedNumberException(final String message) {
        super(message);
    }

    public static AlreadyPickedNumberException alreadyPicked() {
        throw new AlreadyPickedNumberException(ALREADY_PICKED_NUMBER);
    }
}
