package exception;

public enum ErrorMessage {

    PURCHASE_AMOUNT_INVALID_UNIT_MSG("구입 금액은 1,000원 단위여야 합니다."),
    NOT_NUMBER_FORMAT_MSG("숫자로 입력해야 합니다."),
    DUPLICATE_WINNING_NUMBERS_MSG("당첨 번호는 중복되지 않는 숫자여야 합니다."),
    NOT_SIX_WINNING_NUMBERS_MSG("당첨 번호는 6자리여야 합니다."),
    BONUS_NUMBER_IN_WINNING_NUMBERS_MSG("보너스 번호는 당첨 번호에 포함될 수 없습니다."),
    NOT_POSITIVE_NUMBER_MSG("양수로 입력해야 합니다."),
    NOT_ONE_BETWEEN_FORTY_FIVE_MSG("1과 45 사이의 값이어야 합니다.");

    private static final String PREFIX_ERROR_MSG = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX_ERROR_MSG + message;
    }

    public String getMessage() {
        return message;
    }
}
