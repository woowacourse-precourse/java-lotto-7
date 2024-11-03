package lotto.message;

public enum ErrorMessage {
    PAYMENT_IS_BLANK("[ERROR] 공백은 허용되지 않습니다."),
    INVALID_PAYMENT_FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    INVALID_PAYMENT_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
