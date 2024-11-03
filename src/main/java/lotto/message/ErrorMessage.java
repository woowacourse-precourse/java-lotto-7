package lotto.message;

public enum ErrorMessage {
    NOT_DIVISIBLE_ERROR_MESSAGE("금액은 1,000원으로 나누어 떨어져야 합니다."),
    NUMBER_FORMAT_ERROR_MESSAGE("숫자만 입력 가능합니다."),
    NOT_POSITIVE_ERROR_MESSAGE("양수만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
