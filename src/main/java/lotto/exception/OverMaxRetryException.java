package lotto.exception;

public class OverMaxRetryException extends IllegalStateException {

    private static final String MESSAGE = "최대 시도 횟수를 초과했습니다.";

    public OverMaxRetryException() {
        super(MESSAGE);
    }
}
