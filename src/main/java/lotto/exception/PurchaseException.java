package lotto.exception;

import static lotto.constant.Constants.ERROR_PREFIX;

public enum PurchaseException {
    NON_POSITIVE_AMOUNT(ERROR_PREFIX + " 구입 금액은 0보다 커야 합니다."),
    INVALID_UNIT(ERROR_PREFIX + " 구입 금액은 1,000원 단위여야 합니다."),
    EMPTY_INPUT(ERROR_PREFIX + "입력 값이 없습니다."),
    INVALID_FORMAT(ERROR_PREFIX + " 구입 금액은 정수로 입력해야 합니다.");

    private final String message;

    PurchaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
