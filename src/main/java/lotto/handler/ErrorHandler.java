package lotto.handler;

public enum ErrorHandler {
    INCONVERTIBLE_TYPE("유효한 입력값이 아닙니다."),

    INVALID_POSITIVE("구입 금액은 0보다 커야 합니다."),
    INVALID_DIVISION("구입 금액은 1000으로 나누어 떨어져야 합니다."),

    INVALID_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_UNIQUE("로또 번호는 중복되지 않는 숫자여야 합니다."),
    INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        String errorPrefix = "[ERROR]";
        this.errorMessage = errorPrefix + " " + message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
