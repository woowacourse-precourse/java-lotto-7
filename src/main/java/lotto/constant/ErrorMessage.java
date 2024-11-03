package lotto.constant;

public enum ErrorMessage {
    INVALID_LOTTO_LENGTH("로또 번호는 6개여야 합니다."),
    INVALID_NULL_OR_BLANK("입력값이 NULL 혹은 공백일 수 없습니다."),
    INVALID_NON_NUMERIC_INPUT("숫자만 입력 가능합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
