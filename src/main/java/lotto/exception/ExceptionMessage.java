package lotto.exception;

public enum ExceptionMessage {
    PURCHASE_PRICE_BLANK_INPUT("[ERROR] 로또 구입 금액은 공백이 될 수 없습니다."),
    PURCHASE_PRICE_NOT_NUMBER("[ERROR] 로또 구입 금액은 숫자를 입력해주세요."),
    PURCHASE_PRICE_NEGATIVE_NUMBER("[ERROR] 로또 구입 금액은 양수를 입력해주세요."),
    PURCHASE_PRICE_UPPER_LIMIT("[ERROR] 로또 구입 금액은 1억 미만이어야 합니다."),
    PURCHASE_PRICE_NOT_MULTIPLE_OF_THOUSAND("[ERROR] 로또 구입 금액은 1000단위로 입력해야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
