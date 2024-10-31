package lotto.exception;

public enum ExceptionMessage {

    INPUT_BLANK("값을 입력하지 않으셨습니다."),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage(Object... args) {
        return  String.format(message, args);
    }
}
