package lotto.global;

public enum ErrorMessages {
    INVALID_INPUT_FORMAT_NULL("구입 금액 입력값이 비어 있습니다."),

    INVALID_PRICE_FORMAT("로또 구입 금액에는 문자가 포함되면 안됩니다."),
    INVALID_PRICE_FORMAT_UNIT("로또 구입 금액은 1000원 단위의 금액만 가능합니다."),

    INVALID_WINNING_NUMBER_PATTERN("당첨 번호는 쉼표로 구분된 숫자 형식이어야 합니다."),
    INVALID_WINNING_NUM_COUNT("당첨 번호는 6개의 숫자를 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_FORMAT("로또 번호에는 문자가 포함되면 안됩니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
