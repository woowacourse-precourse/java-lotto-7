package lotto.exception;

import static lotto.constant.Constants.ERROR_PREFIX;

import lotto.constant.Constants;

public enum InputNumberException {

    INVALID_LENGTH(ERROR_PREFIX + " 로또 번호는 " + Constants.LOTTO_NUMBER_LENGTH + "개여야 합니다."),
    INVALID_RANGE(ERROR_PREFIX + " 로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_NUMBERS(ERROR_PREFIX + " 로또 번호에 중복이 없어야 합니다."),
    EMPTY_INPUT(ERROR_PREFIX + "입력 값이 없습니다.");

    private final String message;

    InputNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
