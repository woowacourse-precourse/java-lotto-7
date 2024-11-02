package lotto.exception;

public class IllegalLottoNumberException extends IllegalArgumentException {

    public IllegalLottoNumberException() {
        super(ExceptionMessage.LOTTO_NUMBER_EXCEPTION.getMessage());
    }
}
