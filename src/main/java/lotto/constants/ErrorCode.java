package lotto.constants;

public enum ErrorCode {
    MONEY_TYPE_ERROR("금액은 숫자여야 합니다."),
    LOTTO_MIN_PRICE_ERROR("로또 구입 금액은 최소 1000원입니다."),
    LOTTO_PRICE_ERROR("로또 구입 금액은 1000원 단위로 가능합니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45사이여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호에 중복된 숫자가 있습니다."),
    WINNING_NUMBER_TYPE_ERROR("당첨 번호는 숫자여야 합니다."),
    BONUS_NUMBER_TYPE_ERROR("보너스 번호는 숫자여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

    public String toString() {
        return "[ERROR] " + message;
    }
}
