package lotto.viewHandler.exception;

public class NotLottoNumberSize extends MyException {
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
}
