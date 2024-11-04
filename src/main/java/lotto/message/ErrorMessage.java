package lotto.message;

public enum ErrorMessage {
    PAYMENT_EMPTY("공백은 허용되지 않습니다."),
    PAYMENT_NOT_A_NUMBER("숫자를 입력해야 합니다."),
    PAYMENT_INVALID_AMOUNT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    PAYMENT_LIMIT_EXCEEDED("구입 금액은 최대 100,000원으로 제한됩니다."),

    WINNING_NUMBER_INVALID_INPUT("당첨 번호의 입력이 올바르지 않습니다."),
    WINNING_NUMBER_COUNT_INVALID("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_DUPLICATE("당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_INVALID_INPUT("보너스 번호의 입력이 올바르지 않습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}