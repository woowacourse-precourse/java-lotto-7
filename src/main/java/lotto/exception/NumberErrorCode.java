package lotto.exception;

public enum NumberErrorCode {
    NUMBER_PARSE_ERROR("숫자가 아닙니다."),
    NUMBER_DUPLICATE_ERROR("중복되는 숫자가 있습니다."),
    NUMBER_COUNT_ERROR("숫자 갯수가 맞지 않습니다"),
    NUMBER_RANGE_ERROR("숫자 범위가 맞지 않습니다"),
    BONUS_NUMBER_DUPLICATE_WINNING_NUMBER("보너스 번호와 당첨 번호가 중복됩니다."),
    NUMBER_FORMAT_ERROR("숫자 입력 양식이 잘못됐습니다."),
    ;

    private final String message;

    NumberErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
