package lotto.constant;

public enum ExceptionMessage {

    NULL_OR_EMPTY_INPUT("값을 입력해주세요."),
    INPUT_TOO_LONG("값이 너무 큽니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return ERROR_PREFIX.concat(message);
    }

    public String format(Object... args) {
        String formattedMessage = String.format(message, args);
        return ERROR_PREFIX.concat(formattedMessage);
    }
}
