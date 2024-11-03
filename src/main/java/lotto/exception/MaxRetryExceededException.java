package lotto.exception;

public class MaxRetryExceededException extends IllegalStateException {
    private static final String DEFAULT_MESSAGE = "[ERROR] 최대 재시도 횟수 초과";
    public MaxRetryExceededException() {
        super(DEFAULT_MESSAGE);
    }
}
