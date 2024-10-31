package lotto.error;
public enum ExceptionMessage {
    ERROR_MESSAGE_HEAD("[ERROR] "),
    ERROR_MESSAGE_INPUT_IS_EMPTY("빈 문자열을 입력했습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public static String createErrorMessage(ExceptionMessage errorMessage) {
        return ERROR_MESSAGE_HEAD.message + errorMessage.message;
    }
}
