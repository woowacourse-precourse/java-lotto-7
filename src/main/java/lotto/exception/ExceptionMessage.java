package lotto.exception;

import static lotto.validator.PurchaseAmountValidator.MAX_PURCHASE_AMOUNT;
import static lotto.validator.PurchaseAmountValidator.UNIT_PURCHASE_AMOUNT;

public enum ExceptionMessage {
    BLANK_PURCHASE_AMOUNT("공백이 아닌 구입 금액을 입력해주세요."),
    NON_POSITIVE_PURCHASE_AMOUNT("구입 금액은 양수이어야 합니다."),
    NOT_DIVIDED_BY_UNIT_AMOUNT("구입 금액은 단위 금액인 " + UNIT_PURCHASE_AMOUNT + "으로 나누어 떨어져야 합니다."),
    EXCEEDS_MAX_PURCHASE_AMOUNT("구입 금액은 최대 구매가능 금액인 " + MAX_PURCHASE_AMOUNT + "을 넘지 못합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
