package lotto;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000 단위이어야 합니다.");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
