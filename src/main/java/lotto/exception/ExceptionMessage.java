package lotto.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("공백이나 빈 문자열은 허용하지 않습니다."),
    NON_NUMERIC_INPUT("숫자가 아닌 문자가 포함되어 있습니다."),
    INVALID_AMOUNT_UNIT("금액은 1,0000원 단위여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
