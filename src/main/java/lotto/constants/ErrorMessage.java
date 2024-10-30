package lotto.constants;

public enum ErrorMessage {
    PURCHASE_AMOUNT_UNIT_ERROR("[ERROR] 구입 금액은 1000원 단위여야 합니다. 다시 입력해 주세요."),
    LOTTO_NUMBER_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다. 다시 입력해 주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1과 45 사이여야 합니다. 다시 입력해 주세요."),
    LOTTO_DUPLICATION_ERROR("[ERROR] 중복된 번호가 있습니다. 다시 입력해 주세요."),
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다. 다시 입력해 주세요."),
    INPUT_MUST_BE_NUMBER("[ERROR] 입력은 양수인 숫자여야 합니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
