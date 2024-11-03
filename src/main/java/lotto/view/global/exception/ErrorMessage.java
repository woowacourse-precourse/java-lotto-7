package lotto.view.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_AMOUNT_DIVISIBILITY_ERROR("입력된 금액은 1000으로 나누어떨어져야 합니다."),
    INVALID_AMOUNT_TYPE_ERROR("입력된 금액은 양의 정수여야 합니다."),
    INVALID_AMOUNT_RANGE_ERROR("입력된 금액은 올바른 범위 내에 있어야 합니다."),
    INVALID_WINNING_NUMBER_STRING_ERROR("올바른 형식의 숫자 문자열이 아닙니다."),
    INVALID_LOTTO_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER_ERROR("로또 번호는 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final static String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + " " + this.message;
    }
}
