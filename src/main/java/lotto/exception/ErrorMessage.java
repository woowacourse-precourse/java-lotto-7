package lotto.exception;

public enum ErrorMessage {

    DUPLICATE_LOTTO_NUM("로또 번호는 중복되지 않는 번호 6개여야 합니다."),
    INVALID_LOTTO_NUM_FORMAT("로또 번호는 정수로 입력해주세요."),
    OUT_OF_LOTTO_NUM_RANGE("로또 번호는 1부터 45 사이의 정수여야 합니다."),
    INVALID_PAYMENT_AMOUNT("구입 금액으로 0 또는 음수는 입력할 수 없습니다."),
    NON_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 1,000 단위로 입력해주세요."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
