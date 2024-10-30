package lotto.viewHandler.exception;

public class NotLottoNumberSize extends RuntimeException {
    public NotLottoNumberSize() {
        super();
    }

    public NotLottoNumberSize(String message) {
        super(message);
    }

    public NotLottoNumberSize(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLottoNumberSize(Throwable cause) {
        super(cause);
    }

    protected NotLottoNumberSize(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
