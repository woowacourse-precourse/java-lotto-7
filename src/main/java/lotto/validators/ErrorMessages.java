package lotto.validators;

public enum ErrorMessages {
    ERROR_HEADER("[ERROR]"),
    BONUS_NUMBER_IS_DUPLICATE("로또 번호와 중복됩니다."),
    INCORRECT_NUMBER_COUNT("콤마(,)로 구분된 6개의 숫자를 입력해 주세요."),
    INCORRECT_TYPE("소수점이 없는 양수를 입력해 주세요."),
    LOTTO_NUMBER_CONTAINS_DUPLICATE("중복되는 번호가 있습니다."),
    LOTTO_NUMBER_NOT_WITHIN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DIVISIBLE("천 단위의 금액을 입력해 주세요."),
    PURCHASE_AMOUNT_NOT_WITHIN_RANGE("구입금액은 1,000원 이상, 100,000원 이하여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
