package lotto.controller.error;

public enum ErrorType {

    INVALID_DELIMITER("로또 번호 구분자 형식이 잘못되었습니다."),
    NULL_OR_BLANK_INPUT("입력이 null이거나 빈 문자열일 수 없습니다."),
    INVALID_NUMBER_FORMAT("입력이 int 범위를 벗어났거나 숫자가 아닙니다."),
    NEGATIVE_AMOUNT("구입 금액이 음수가 될 수 없습니다."),
    INVALID_UNIT_AMOUNT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("중복된 번호가 존재합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 값이어야 합니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
