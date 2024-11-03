package lotto;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 로또 구매금액은 1000원 이상이어야 합니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 로또 구매금액은 1000원 단위로 가능합니다."),
    INVALID_WIN_NUMBER_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
