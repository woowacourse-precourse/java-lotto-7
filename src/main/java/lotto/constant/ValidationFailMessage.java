package lotto.constant;

public enum ValidationFailMessage {
    EMPTY_INPUT("비어있는 값은 허용하지 않습니다."),
    NON_NUMERIC_INPUT("숫자가 아닌 값은 허용하지 않습니다."),
    OUT_OF_PARSE_RANGE("범위를 벗어난 값은 허용하지 않습니다."),
    ZERO_OR_MINUS_INPUT("0보다 작은 값 허용하지 않습니다.");

    private final String message;

    ValidationFailMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
