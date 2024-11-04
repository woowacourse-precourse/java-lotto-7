package lotto.exception;

public enum ErrorMessage {
    MAX_LOTTO_COUNT_ERROR("[ERROR] 로또는 최대 100개까지만 발행할 수 있습니다."),
    INVALID_LOTTO_NUMS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUM_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUM_NOT_IN_RANGE("[ERROR] 숫자의 범위는 1~45까지 입니다."),
    INVALID_NUM("[ERROR] 유효한 숫자가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구매 금액은 1000원 단위여야 합니다."),
    BONUS_NUM_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }
}
