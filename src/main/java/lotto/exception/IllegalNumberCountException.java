package lotto.exception;

public class IllegalNumberCountException extends IllegalArgumentException {

    public IllegalNumberCountException() {
        super(ExceptionMessage.LOTTO_NUMBER_COUNT_EXCEPTION.getMessage());
    }
}
