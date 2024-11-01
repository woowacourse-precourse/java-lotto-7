package lotto.constants;

public enum ErrorMessage {
    INPUT_EMPTY("입력이 없거나 공백이어선 안됩니다."),
    MONEY_NOT_INTEGER("구입금액은 정수만 입력되어야 합니다."),
    MONEY_NOT_POSITIVE("구입금액은 0 이상의 양수만 입력되어야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG + message;
    }
}