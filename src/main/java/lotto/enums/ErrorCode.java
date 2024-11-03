package lotto.enums;

public enum ErrorCode {
    MONEY_TYPE_ERROR("[ERROR] 금액은 숫자여야 합니다."),
    LOTTO_MIN_PRICE_ERROR("[ERROR] 로또 구입 금액은 최소 1000원입니다."),
    LOTTO_PRICE_ERROR("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
