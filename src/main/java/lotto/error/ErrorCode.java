package lotto.error;

public enum ErrorCode {

    BLANK_INPUT_MESSAGE("빈 문자열은 입력 받을 수 없습니다."),
    NOT_INTEGER("구입 금액은 정수 범위가 아닌 값이나 문자는 입력할 수 없습니다."),
    UNAVAILABLE_MIN_AMOUNT("로또의 최소 구입 금액은 1000원입니다."),
    NOT_MULTIPLE_OF_1000("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATED_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    WINNING_LOTTO_NOT_EXIST("당첨 번호가 존재하지 않습니다.")
    ;

    private final String value;
    private static final String PREFIX = "[ERROR] ";

    ErrorCode(String value) {
        this.value = value;
    }

    public String getMessage() {
        return PREFIX + value;
    }
}
