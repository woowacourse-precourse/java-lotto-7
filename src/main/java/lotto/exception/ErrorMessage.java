package lotto.exception;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    CONTAIN_BLANK("공백을 포함한 문자열은 입력할 수 없습니다."),
    IS_EMPTY("빈 문자열은 입력할 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("구입금액은 1000, 2000, ..., 100000 중 하나의 값이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX.message + message;
    }
}
