package lotto.exceptions;

public class StateException extends IllegalStateException {
    enum Error {
        EMPTY_AUTO_BONUS_BALL("[ERROR] 보너스 번호가 추첨되지 않았습니다."),
        INVALID_QUANTITY("[ERROR] 유효하지 않은 로또의 수량입니다.");
        public final String message;

        Error(final String message) {
            this.message = message;
        }
    }

    public static final StateException EMPTY_AUTO_BONUS_BALL = new StateException(Error.EMPTY_AUTO_BONUS_BALL.message);
    public static final StateException INVALID_QUANTITY = new StateException(Error.INVALID_QUANTITY.message);

    public StateException(final String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
