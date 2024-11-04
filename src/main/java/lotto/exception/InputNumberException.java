package lotto.exception;

import static lotto.constant.Constants.ERROR_PREFIX;

import lotto.constant.Constants;

public enum InputNumberException {

    INVALID_LENGTH(ERROR_PREFIX + " 로또 번호는 " + Constants.LOTTO_NUMBER_LENGTH + "개여야 합니다."),
    INVALID_RANGE(ERROR_PREFIX + " 로또 번호는 " + Constants.LOTTO_NUMBER_RANGE_START + "부터 " + Constants.LOTTO_NUMBER_RANGE_END + " 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS(ERROR_PREFIX + " 로또 번호에 중복이 없어야 합니다."),
    DUPLICATE_NUMBER_WITH_WINNING_NUMBERS(ERROR_PREFIX + " 보너스 번호가 당첨 번호와 같으면 중복이 없어야 합니다."),
    INVALID_FORMAT(ERROR_PREFIX + "당첨 번호는 숫자여야 합니다."),
    ENDS_WITH_COMMA(ERROR_PREFIX + "입력 값은 쉼표로 끝날 수 없습니다."),
    EMPTY_INPUT(ERROR_PREFIX + "입력 값이 없습니다.");

    private final String message;

    InputNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
