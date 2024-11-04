package lotto.util;

public enum ErrorMessages {
    INVALID_PURCHASE_PRICE("구입 금액은 1000원 단위입니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다."),

    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호에 중복된 숫자가 존재합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    INVALID_PURCHASE_PRICE_FORMAT("구입금액의 양식이 올바르지 않습니다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호의 양식이 올바르지 않습니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호의 양식이 올바르지 않습니다.");

    private static final String ERROR_MSG_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MSG_FORMAT, this.message);
    }
}
