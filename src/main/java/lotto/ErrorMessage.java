package lotto;

public enum ErrorMessage {
    NUMERIC_VALUE_ERROR("숫자를 입력해주세요."),
    PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR("구매 금액을 1000원 단위로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
