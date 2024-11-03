package lotto.exception;

public enum ErrorMessage {

    NUMBER_NOT_DIVIDE_THOUSAND("숫자는 1,000 단위로 나누어 떨어져야 합니다"),
    ;


    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String get() {
        return message;
    }
}
