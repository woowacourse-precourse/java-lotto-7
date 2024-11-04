package lotto.constants;

public enum ErrorMessages {
    MIN_AMOUNT("최소 %s원 이상 구매하셔야합니다."),
    MAX_AMOUNT("최대 %s원 까지만 구매가 가능합니다."),
    UNIT_AMOUNT("%s원 단위로만 구매가 가능합니다."),
    INVALID_AMOUNT("유효하지 않은 금액입니다. 숫자 형식으로 입력해주세요."),
    START_END_DELIMITER("시작과 끝부분에 구분자가 포함될 수 없습니다."),
    WHITESPACE_IN_DELIMITER("구분자 사이에 공백이 포함될 수 없습니다."),
    INVALID_CHARACTERS("당첨 번호에는 숫자와 허용된 구분자 외의 문자가 포함될 수 없습니다."),
    NON_NUMERIC_VALUE("숫자가 아닌값은 입력할 수 없습니다."),
    DUPLICATE_WITH_WINNING_NUMBER("당첨 번호에 중복되는 숫자가 존재합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1~45사이의 숫자만 입력이 가능합니다."),
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    IMPOSSIBLE_SITUATION("실제로 불가능한 상황에서 의미없는 반복 실행을 방지하기 위해 종료됩니다.");

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
