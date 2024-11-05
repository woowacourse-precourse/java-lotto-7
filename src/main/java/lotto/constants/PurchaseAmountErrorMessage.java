package lotto.constants;

import static lotto.constants.ErrorConstants.*;

public enum PurchaseAmountErrorMessage implements ErrorMessage {
    INVALID_NUMBER_FORMAT("구입 금액은 숫자여야 합니다."),
    BELOW_MINIMUM_AMOUNT("구입 금액은 1000원 이상이어야 합니다."),
    NOT_DIVISIBLE_BY_MINIMUM("구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    PurchaseAmountErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
