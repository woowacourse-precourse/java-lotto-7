package lotto;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
