package lotto.Messages;

public enum ErrorMessage {
    EMPTY_PURCHASE_AMOUNT("구입 금액은 빈 문자열로 입력할 수 없습니다."),
    BLANK_PURCHASE_AMOUNT("구입 금액을  공백 문자열로 입력할 수 없습니다."),
    NOT_NUMERIC_PURCHASE_AMOUNT("구입 금액은 숫자만 입력할 수 있습니다."),
    RANGE_PURCHASE_AMOUNT("구입 금액은 정수 범위를 초과할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
