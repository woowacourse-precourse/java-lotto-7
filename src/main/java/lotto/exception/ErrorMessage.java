package lotto.exception;

public enum ErrorMessage {
    ERROR_EMPTY_VALUE("[ERROR] 입력 값이 없습니다."),
    ERROR_INVALID_NUMBER("[ERROR] 입력 값이 숫자가 아닙니다."),
    ERROR_NEGATIVE_NUMBER("[ERROR] 입력 값은 음수가 될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
