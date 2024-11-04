package lotto.utils;

public enum DefaultErrorMessage {
    INVALID_INTEGER_FORMAT("[ERROR] 정수형식이 아니거나, 너무 큰 숫자입니다."),
    NULL_OR_EMPTY_INPUT("[ERROR] 입력 값이 유효하지 않습니다. 빈 값이나 공백만 입력할 수 없습니다.");

    private final String message;

    DefaultErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
