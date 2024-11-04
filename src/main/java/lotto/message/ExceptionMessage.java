package lotto.message;

public enum ExceptionMessage {
    INVALID_BLANK_INPUT("null 또는 빈 값은 입력할 수 없습니다."),
    INVALID_TYPE_INPUT("%s은(는) %s여야 합니다."),
    INVALID_RANGE_INPUT("%s은(는) %d부터 %d 사이의 숫자여야 합니다."),
    INVALID_NUMBER_INPUT("%s은(는) %d로 나누어 떨어져야 합니다."),
    INVALID_DUPLICATION_INPUT("%s에 중복값이 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public String getMessage() {
        return message;
    }
}
