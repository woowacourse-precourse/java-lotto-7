package lotto.infrastructure.exception;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 숫자로만 이루어져야 합니다."),
    INVALID_LOTTO_DELIMITER_POSITION("로또 번호 앞 뒤에 구분자가 포함될 수 없습니다."),
    INVALID_LOTTO_CONSECUTIVE_DELIMITERS("로또 번호에 연속적인 구분자가 포함될 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1 이상 45 이하의 숫자입니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
