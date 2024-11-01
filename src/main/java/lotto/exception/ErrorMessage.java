package lotto.exception;

public enum ErrorMessage {
    BLANK_PURCHASE_AMOUNT("로또 구입 금액을 입력하지 않았습니다."),
    NOT_NUMERIC_PURCHASE_AMOUNT("구입 금액은 숫자여야 합니다."),
    NEGATIVE_PURCHASE_AMOUNT("구입 금액은 음수가 될 수 없습니다."),
    TOO_BIG_PURCHASE_AMOUNT("구입 금액이 너무 큽니다."),
    UNDER_THOUSAND_PURCHASE_AMOUNT("구입 금액은 최소 1,000원 이상이어야 합니다."),
    NOT_THOUSAND_UNIT_PURCHASE_AMOUNT("구입 금액은 1,000원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
