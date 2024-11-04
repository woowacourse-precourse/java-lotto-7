package lotto.exception.constants;

public enum ExceptionMessage {

    ERROR_PREFIX("[ERROR] ");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String format(final String content) {
        return message + content;
    }

    public String getMessage() {
        return message;
    }
}
