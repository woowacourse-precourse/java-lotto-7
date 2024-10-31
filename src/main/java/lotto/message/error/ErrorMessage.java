package lotto.message.error;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 로또 구매는 1,000원 단위만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
