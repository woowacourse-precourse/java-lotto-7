package lotto.exception;

public enum ExceptionMessage {
    EXCEPTION_PREFIX("[ERROR] "),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_MONEY_INPUT("최소 구입금액은 1,000원이며 1,000원 단위로만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_SIZE("당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("당첨 번호는 1~45 사이의 숫자만 입력 가능합니다."),
    DUPLICATE_WINNING_NUMBER("중복 당첨 번호는 입력이 불가능합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1~45 사이의 숫자만 입력 가능합니다."),
    DUPLICATE_BONUS_NUMBER("중복 보너스 번호는 입력이 불가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_PREFIX.message + message;
    }
}
