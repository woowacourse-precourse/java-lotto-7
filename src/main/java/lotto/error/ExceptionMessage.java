package lotto.error;

public enum ExceptionMessage {
    ERROR_MESSAGE_INPUT_IS_EMPTY("빈 문자열을 입력했습니다."),
    ERROR_MESSAGE_IS_NOT_NUMBER("올바른 정수 형식이 아닙니다."),
    ERROR_MESSAGE_IS_NOT_POSITIVE_NUMBER("값이 0 이하입니다."),
    ERROR_MESSAGE_IS_NOT_VALID_COST("구입 금액이 나누어 떨어지지 않습니다."),
    ;

    private final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE_HEAD + message;
    }

    public static void throwException(ExceptionMessage exception) {
        throw new IllegalArgumentException(exception.toString());
    }
}
