package lotto.common.exception;

import static lotto.common.constant.LottoIntegerConstant.LOTTO_PRICE;

public enum ErrorMessage {

    INPUT_NULL_OR_EMPTY_ERROR("값이 입력되지 않았습니다."),
    INPUT_NOT_INTEGER_ERROR("정수를 입력해주세요."),

    LOTTO_NUMBERS_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATION_ERROR("로또 번호는 중복되지 않아야 합니다."),

    LOTTO_NUMBER_OUT_OF_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    PURCHASE_AMOUNT_VALUE_ERROR("로또 구입 금액은 " + LOTTO_PRICE.number() + "으로 나누어떨어져야 합니다."),

    WINNING_NUMBERS_COUNT_ERROR("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBERS_DUPLICATION_ERROR("당첨 번호는 중복되지 않아야 합니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String message() {
        return message;
    }
}
