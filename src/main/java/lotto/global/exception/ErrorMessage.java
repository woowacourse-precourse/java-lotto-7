package lotto.global.exception;

public enum ErrorMessage {

    REQUIRED_POSITIVE_NUMBER("구매 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NEGATIVE_NUMBER("로또 번호는 0 또는 음수일 수 없습니다."),
    DUPLICATED_NUMBER_INPUT("중복된 숫자는 입력할 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}