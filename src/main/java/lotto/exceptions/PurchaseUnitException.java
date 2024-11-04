package lotto.exceptions;

import static lotto.constants.ExceptionDisplayConstants.USER_INPUT_ERROR_PREFIX;

public class PurchaseUnitException extends IllegalArgumentException{
    private static final String MESSAGE = USER_INPUT_ERROR_PREFIX + " 구매금액은 1000으로 나누어 떨어지 양수여야 합니다.";

    public PurchaseUnitException() {
        super(MESSAGE);
    }
}
