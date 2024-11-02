package lotto.validators.constants;

public enum ErrorMessages {
    BONUS_NUMBER_IS_DUPLICATE("[ERROR] 로또 번호와 중복됩니다."),
    INCORRECT_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INCORRECT_TYPE("[ERROR] 소수점이 없는 양수를 입력해 주세요."),
    LOTTO_NUMBER_CONTAINS_DUPLICATE("[ERROR] 중복되는 번호가 있습니다."),
    LOTTO_NUMBER_NOT_WITHIN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DIVISIBLE("[ERROR] 천 단위의 금액을 입력해 주세요."),
    PURCHASE_AMOUNT_NOT_WITHIN_RANGE("[ERROR] 구입금액은 1,000원 이상, 100,000원 이하여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
