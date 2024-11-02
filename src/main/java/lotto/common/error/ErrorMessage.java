package lotto.common.error;

public enum ErrorMessage {
    LOTTO_MAX_PURCHASE_ERROR_MESSAGE("[ERROR] 구입할 수 있는 최대 로또 용지는 10장 입니다."),
    PURCHASE_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 %d원 단위여야 합니다."),
    LOTTO_NUMBERS_SIZE_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    BONUS_DUPLICATE_ERROR_MESSAGE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE("[ERROR] 하나의 로또 내의 번호는 중복되지 않아야 합니다."),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    AMOUNT_SHOULD_NUMBER_ERROR_MESSAGE("[ERROR] 금액은 음수가 아닌 양수여야 합니다."),
    INPUT_NOT_BLANK_ERROR_MESSAGE("[ERROR] 입력값은 null 이거나 비어있지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

    @Override
    public String toString() {
        return message;
    }
}
