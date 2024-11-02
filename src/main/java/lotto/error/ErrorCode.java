package lotto.error;

public enum ErrorCode {

    BLANK_INPUT_MESSAGE("빈 문자열은 입력 받을 수 없습니다.");

    private final String value;
    private static final String PREFIX = "[ERROR] ";

    ErrorCode(String value) {
        this.value = value;
    }

    public String getMessage() {
        return PREFIX + value;
    }
}
