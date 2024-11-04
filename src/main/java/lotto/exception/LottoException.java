package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private static final String MESSAGE_FORMAT = "%s: %d";

    private LottoException(String message) {
        super(message);
    }

    public static LottoException from(ErrorMessage errorMessage) {
        return new LottoException(errorMessage.getMessage());
    }

    public static LottoException of(ErrorMessage errorMessage, int number) {
        return new LottoException(String.format(MESSAGE_FORMAT, errorMessage.getMessage(), number));
    }
}
