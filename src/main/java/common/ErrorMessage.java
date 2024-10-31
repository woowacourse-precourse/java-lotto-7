package common;

public enum ErrorMessage {
    PURCHASE_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 %d원 단위여야 합니다."),
    LOTTO_NUMBERS_SIZE_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    BONUS_DUPLICATE_ERROR_MESSAGE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE("[ERROR] 하나의 로또 내의 번호는 중복되지 않아야 합니다."),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
