package lotto.message;

public enum ErrorMessage {

    NON_INTEGER_PURCHASE_AMOUNT("[ERROR] 구입 금액은 정수여야 합니다."),
    NEGATIVE_PURCHASE_AMOUNT("[ERROR] 구입 금액은 0 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("[ERROR] 6개의 로또 번호는 중복될 수 없습니다."),
    NON_INTEGER_LOTTO("[ERROR] 로또 번호는 정수여야 합니다."),
    LOTTO_SCOPE_ERROR("[ERROR] 로또 번호는 1 이상 45 이하의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
