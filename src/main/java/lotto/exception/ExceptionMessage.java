package lotto.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("공백이나 빈 문자열은 허용하지 않습니다."),
    NON_NUMERIC_INPUT("숫자가 아닌 문자가 포함되어 있습니다."),
    INVALID_AMOUNT_UNIT("금액은 1,0000원 단위여야 합니다."),
    ONLY_POSITIVE_INPUT("입력은 양의 정수여야 합니다."),
    POSITIVE_SIGN_INPUT("양의 부호를 포함할 수 없습니다."),
    INVALID_COMMA_POSITION("입력 값의 맨 앞이나 맨 뒤에 쉼표가 올 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
