package lotto.exception;

public enum ErrorMessage {

    INVALID_PURCHASE_MONEY("구입금액은 1000원 이상이면서 1000원 단위여야 합니다."),
    INVALID_INPUT_NUMBER("숫자만 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
