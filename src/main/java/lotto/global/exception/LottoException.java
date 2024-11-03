package lotto.global.exception;

public class LottoException extends IllegalArgumentException {

    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    private LottoException(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        super(errorMessage.getMessage(), exception);
    }

    public static LottoException from(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }

    public static LottoException of(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        return new LottoException(errorMessage, exception);
    }
}