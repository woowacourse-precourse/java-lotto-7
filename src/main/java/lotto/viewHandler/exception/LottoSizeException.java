package lotto.viewHandler.exception;

public class LottoSizeException extends MyException {
    public LottoSizeException() {
        super();
    }

    public LottoSizeException(String message) {
        super(message);
    }

    public LottoSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LottoSizeException(Throwable cause) {
        super(cause);
    }
}
