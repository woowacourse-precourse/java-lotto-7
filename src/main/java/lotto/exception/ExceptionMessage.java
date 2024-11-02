package lotto.exception;

public enum ExceptionMessage {
    NON_POSITIVE_PURCHASE_AMOUNT("구입 금액은 양수이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
