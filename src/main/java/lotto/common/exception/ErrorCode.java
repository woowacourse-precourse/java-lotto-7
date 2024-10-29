package lotto.common.exception;

import static lotto.common.constant.LottoConst.*;

public enum ErrorCode {

    // amount input
    NOT_NUMBER(NOT_NUMBER_MSG),
    CANT_DIVIDE(CANT_DIVIDE_MSG),
    LOTTO_INVALID_QUANTITY(LOTTO_INVALID_QUANTITY_MSG),
    LOTTO_NOT_DISTINCT_NUMBERS(LOTTO_NOT_DISTINCT_NUMBERS_MSG),

    // winning number input
    INCORRECT_WINNING_NUMBER(INVALID_WINNING_NUMBER_FORMAT_MSG);

    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
