package message;

public enum ErrorMessage {
    EMPTY_INPUT("구입 금액은 비어 있을 수 없습니다."),
    NOT_NUMERIC("구입 금액은 숫자여야 합니다."),
    POSITIVE_AMOUNT("구입 금액은 0보다 커야 합니다."),
    THOUSAND_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    MAX_PURCHASE_AMOUNT("구입 금액은 100,000원을 넘을 수 없습니다."),
    WINNING_NUMBER_FORMAT("당첨 번호는 6개의 숫자로 구성되어야 하며, 콤마로 구분되어야 합니다."),
    WINNING_NUMBER_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("당첨 번호에는 중복된 숫자가 있을 수 없습니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호에는 중복된 숫자가 있을 수 없습니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return ERROR_PREFIX + message;
    }
}
