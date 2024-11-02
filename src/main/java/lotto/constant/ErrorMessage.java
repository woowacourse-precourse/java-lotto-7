package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT("[ERROR]: 입력값은 null이 될 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR]: 구매 금액은 [숫자] 또는 [+숫자]이 가능합니다."),
    WHITESPACE_IN_PURCHASE_AMOUNT("[ERROR]: 구입 금액 숫자 사이에 공백이 포함될 수 없습니다."),
    OUT_OF_RANGE_PURCHASE_AMOUNT("[ERROR]: 구입 금액은 0원에서 100,000원 사이여야 합니다."),
    NOT_DIVIDED_PURCHASE_AMOUNT("[ERROR]: 구입 금액은 1000원 단위로 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
