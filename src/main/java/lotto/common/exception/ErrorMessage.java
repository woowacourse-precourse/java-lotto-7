package lotto.common.exception;

public enum ErrorMessage {
    INPUT_NULL_OR_EMPTY_ERROR("값이 입력되지 않았습니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String message() {
        return message;
    }
}
