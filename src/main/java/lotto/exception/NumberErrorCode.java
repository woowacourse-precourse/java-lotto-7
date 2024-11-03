package lotto.exception;

public enum NumberErrorCode {
    NUMBER_PARSE_ERROR("당첨번호는 숫자여야 합니다"),
    NUMBER_DUPLICATE_ERROR("중복되는 숫자가 있습니다."),
    NUMBER_COUNT_ERROR("숫자 갯수가 맞지 않습니다"),
    NUMBER_RANGE_ERROR("숫자 범위가 맞지 않습니다");

    private final String message;

    NumberErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
