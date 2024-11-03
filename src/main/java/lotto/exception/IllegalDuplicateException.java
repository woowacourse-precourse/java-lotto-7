package lotto.exception;

public class IllegalDuplicateException extends IllegalArgumentException {

    public IllegalDuplicateException() {
        super(ExceptionMessage.LOTTO_NUMBER_DUPLICATE_EXCEPTION.getMessage());
    }
}
