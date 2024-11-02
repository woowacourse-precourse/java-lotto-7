package lotto.exception;

public enum Exception {
    ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT("구입 금액은 숫자만 입력할 수 있습니다."),
    PURCHASE_AMOUNT_MUST_BE_POSITIVE("구입 금액은 0보다 커야 합니다."),
    ONLY_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 1000원 단위로 나누어떨어져야 합니다."),

    ONLY_NUMERIC_INPUT_FOR_WINNING_NUMBERS("당첨 번호는 숫자만 입력할 수 있습니다."),
    LOTTO_NUMBER_SIZE_MUST_BE_SIX("로또 번호는 6개여야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
