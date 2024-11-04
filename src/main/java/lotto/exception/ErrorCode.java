package lotto.exception;

public enum ErrorCode {
    LOTTO_NUMBERS_NOT_A_NUMBER("로또 번호는 숫자여야합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_INVALID_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    PURCHASE_AMOUNT_NOT_A_NUMBER("로또 구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_NOT_IN_UNITS_OF_THOUSAND("로또 구입 금액은 1000원 단위여야 합니다."),
    PURCHASE_AMOUNT_NEGATIVE("로또 구입 금액은 음수가 될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}