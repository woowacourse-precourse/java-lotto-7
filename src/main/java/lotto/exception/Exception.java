package lotto.exception;

public enum Exception {
    INVALID_NUMBER("유효한 숫자를 입력해 주세요."),
    INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    MINIMUM_LOTTO_COUNT_REQUIRED("로또는 최소 1장이상 구매하여야합니다."),
    MAXIMUM_NUMBER_LENGTH("숫자는 9자 이내여야합니다."),
    LOTTO_AMOUNT_NOT_DIVISIBLE("입력 금액은 로또 금액(1000원)으로 나누어 떨어져야합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    DUPLICATED_BONUS_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
