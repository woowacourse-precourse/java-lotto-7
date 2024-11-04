package lotto.exception;

public enum ExceptionCode {

    INVALID_NUMBER_FORMAT("숫자를 입력해주세요.");

    private final String message;

    ExceptionCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
