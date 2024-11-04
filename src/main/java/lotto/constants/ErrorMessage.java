package lotto.constants;

public enum ErrorMessage {
    PURCHASE_MONEY_ONLY_CAN_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    PURCHASE_MONEY_ONLY_CAN_THOUSAND_UNIT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_NUMBER_ONLY_CAN_MONEY("[ERROR] 로또 번호는 숫자여야 합니다."),
    LOTTO_NUMBER_ONLY_CAN_LENGTH_6("[ERROR] 로또 번호는 중복되지 않은 6개의 숫자여야 합니다."),
    LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_ONLY_CAN_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_ONLY_CAN_RANGE_1_TO_45("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_CAN_NOT_BE_DUPLICATED_LOTTO_NUMBER("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
