package lotto.common;

public enum ErrorMessage {
    NULL_OR_EMPTY("구입 금액을 입력해 주세요."),
    NOT_POSITIVE("양의 정수를 입력해 주세요."),
    INVALID_NUMBER("올바른 금액을 입력해 주세요."),
    NOT_DISABLE_BY_1000("1000원 단위로 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

}
