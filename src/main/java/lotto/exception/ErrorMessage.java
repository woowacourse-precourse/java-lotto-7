package lotto.exception;

public enum ErrorMessage {
    LOTTO_PURCHASE_IS_NOT_NUMBER("[ERROR] 구입 금액은 숫자만 입력하셔야 합니다."),
    LOTTO_PURCHASE_IS_ZERO("[ERROR] 구입 금액은 0원이 아닌 수를 입력하셔야 합니다."),
    LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력하셔야 합니다."),
    WINNING_LOTTO_IS_NOT_NUMBER("[ERROR] 당첨 번호는 숫자를 입력하셔야 합니다."),
    WINNING_LOTTO_IS_NOT_SIX_LENGTH("[ERROR] 당첨 번호는 6자리 입력하셔야 합니다."),
    WINNING_LOTTO_RANGE_ERROR("[ERROR] 당첨 번호는 1~45 사이의 수를 입력하셔야 합니다."),
    WINNING_LOTTO_DUPLICATE_ERROR("[ERROR] 당첨 번호는 중복된 수 없이 입력하셔야 합니다."),
    BONUS_NUMBER_IS_NOT_NUMBER("[ERROR] 보너스 번호는 숫자를 입력하셔야 합니다"),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 번호는 1~45 사이의 수를 입력하셔야 합니다."),
    BONUS_NUMBER_DUPLICATE_WINNING_LOTTO("[ERROR] 보너스 번호는 당첨 번호와 중복된 수 없이 입력하셔야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
