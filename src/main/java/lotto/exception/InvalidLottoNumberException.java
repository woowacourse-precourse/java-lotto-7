package lotto.exception;

public class InvalidLottoNumberException extends CustomIllegalArgumentException {

    public InvalidLottoNumberException(final String message) {
        super(message);
    }
}
