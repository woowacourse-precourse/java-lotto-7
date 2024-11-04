package lotto.error;

public enum ErrorCode {

    BLANK_INPUT_MESSAGE("빈 문자열은 입력 받을 수 없습니다."),
    NOT_INTEGER("구입 금액은 정수 범위가 아닌 값이나 문자는 입력할 수 없습니다."),
    NOT_POSITIVE("구입 금액은 양수 범위여야합니다."),
    NOT_MULTIPLE_OF_1000("구입 금액은 1,000원 단위여야 합니다.")
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
