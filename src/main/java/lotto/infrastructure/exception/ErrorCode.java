package lotto.infrastructure.exception;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_NUMBER_FORMAT("올바른 숫자 형식만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 숫자 형식이어야 합니다."),
    INVALID_LOTTO_DELIMITER_POSITION("로또 번호 앞뒤에 구분자를 사용할 수 없습니다."),
    INVALID_LOTTO_CONSECUTIVE_DELIMITERS("로또 번호에 연속된 구분자를 사용할 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DUPLICATED_NUMBER("로또 번호에 중복된 숫자가 있을 수 없습니다."),
    INVALID_LOTTO_DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
