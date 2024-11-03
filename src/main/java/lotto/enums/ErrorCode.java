package lotto.enums;

public enum ErrorCode {
    MONEY_TYPE_ERROR("[ERROR] 금액은 숫자여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
