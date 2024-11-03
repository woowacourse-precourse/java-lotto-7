package lotto.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자만 입력할 수 있습니다."),
    MINIMUM_AMOUNT("1,000원이상부터 구매할 수 있습니다."),
    INVALID_WINNING_NUMBER_FORMAT("올바른 형식의 입력이 아닙니다.");

    private final String PREFIX = "[ERROR] ";
    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + this.message;
    }
}
