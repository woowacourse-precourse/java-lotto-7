package lotto.exception;

public class LottoDuplicationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다";

    public LottoDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
