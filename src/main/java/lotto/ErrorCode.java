package lotto;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 숫자로만 이루어져야 합니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
