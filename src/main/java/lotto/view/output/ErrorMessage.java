package lotto.view.output;

public enum ErrorMessage {

    NULL_INPUT_ERROR("빈 입력입니다."),
    INVALID_NUMBER_FORMAT("숫자 형식이 잘못되었습니다."),
    MONEY_IS_UNDER_1000("금액은 1000 이상이어야 합니다."),
    MONEY_IS_NOT_MULTIPLE_1000("금액은 1000으로 나누어 떨어져야 합니다."),

    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }

}
