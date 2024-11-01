package lotto.util;

public enum ErrorCode {

    INVALD_PURCHASE_AMOUNT("구매 금액은 1,000원 이상 100,000원 이하이고, 1,000으로 나누어 떨어져야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = Constant.ERROR_PREFIX + message;
    }

    public IllegalArgumentException exception() {
        return new IllegalArgumentException(this.message);
    }

    public String getMessage() {
        return message;
    }
}
