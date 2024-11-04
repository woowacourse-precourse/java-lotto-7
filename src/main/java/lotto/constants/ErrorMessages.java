package lotto.constants;

public enum ErrorMessages {
    MIN_AMOUNT("최소 %s원 이상 구매하셔야합니다."),
    MAX_AMOUNT("최대 %s원 까지만 구매가 가능합니다."),
    UNIT_AMOUNT("%s원 단위로만 구매가 가능합니다."),
    INVALID_AMOUNT("유효하지 않은 금액입니다. 숫자 형식으로 입력해주세요."),
    START_END_DELIMITER("시작과 끝부분에 구분자가 포함될 수 없습니다."),
    WHITESPACE_IN_DELIMITER("구분자 사이에 공백이 포함될 수 없습니다."),
    INVALID_CHARACTERS("당첨 번호에는 숫자와 허용된 구분자 외의 문자가 포함될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        String customMessage = PREFIX + message;
        return String.format(customMessage, args);
    }
}
