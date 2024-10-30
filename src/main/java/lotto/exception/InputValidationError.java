package lotto.exception;

public enum InputValidationError {

    EMPTY_INPUT("입력은 빈 값일 수 없습니다."),
    INVALID_NUMERIC_FORMAT("올바른 숫자 형식이 아닙니다."),
    INVALID_INPUT_FORMAT("올바른 입력 형식이 아닙니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    InputValidationError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public void throwException(Object... args) {
        throw new InvalidInputException(getMessage(args));
    }

    private String getMessage(Object... args) {
        return String.format(message, args);
    }
}
