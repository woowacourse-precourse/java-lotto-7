package lotto.exception;

public class CustomLottoException extends IllegalArgumentException {
    public CustomLottoException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}