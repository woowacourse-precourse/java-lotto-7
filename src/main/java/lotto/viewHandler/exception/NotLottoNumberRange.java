package lotto.viewHandler.exception;

public class NotLottoNumberRange extends MyException {
    public NotLottoNumberRange() {
        super();
    }

    public NotLottoNumberRange(String message) {
        super(message);
    }

    public NotLottoNumberRange(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLottoNumberRange(Throwable cause) {
        super(cause);
    }
}
