package lotto.exception;

public enum Exception {
    ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT("구입 금액은 숫자만 입력할 수 있습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
