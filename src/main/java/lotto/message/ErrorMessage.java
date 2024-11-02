package lotto.message;

public enum ErrorMessage {

    INVALID_PURCHASE_AMOUNT("구입 금액은 0 이상의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
