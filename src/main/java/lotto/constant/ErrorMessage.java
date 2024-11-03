package lotto.constant;

public enum ErrorMessage {
    INVALID_LOTTO_LENGTH("로또 번호는 6개여야 합니다."),
    INVALID_NULL_OR_BLANK("입력값이 NULL 혹은 공백일 수 없습니다."),
    INVALID_NON_NUMERIC_INPUT("양수인 숫자만 입력 가능합니다."),
    INVALID_ZERO_AMOUNT("구입금액은 0원일 수 없습니다."),
    INVALID_AMOUNT_UNIT("구입금액의 단위는 1,000원 단위입니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_COUNT("보너스 번호는 1개의 숫자만 입력 가능합니다"),
    BONUS_NUMBER_ALREADY_IN_WINNING_NUMBERS("해당 보너스 번호는 당첨 번호에 입력되어 있습니다"),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
