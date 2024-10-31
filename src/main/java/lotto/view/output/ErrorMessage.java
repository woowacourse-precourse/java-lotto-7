package lotto.view.output;

public enum ErrorMessage {

    NULL_INPUT_ERROR("빈 입력입니다."),
    INVALID_NUMBER_FORMAT("숫자 형식이 잘못되었습니다."),
    ;

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }

}
