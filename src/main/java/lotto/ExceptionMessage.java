package lotto;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION("구입금액은 숫자로만 이루어져야 합니다."),
    PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION("구입금액은 1000원으로 나누어 떨어져야 합니다."),

    LOTTO_NUMBER_LENGTH_EXCEPTION("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_EXCEPTION("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    WINNING_NUMBERS_NOT_NUMERIC_EXCEPTION("당첨 번호는 숫자로만 이루어져야 합니다."),
    WINNING_NUMBER_LENGTH_EXCEPTION("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_DUPLICATE_EXCEPTION("당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_NOT_NUMERIC_EXCEPTION("보너스 번호는 숫자로만 이루어져야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_EXCEPTION("보너스 번호는 당첨 번호와 중복될 수 없습니다.");


    private final String exceptionMessagePrefix = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessagePrefix + exceptionMessage;
    }

    public String message() {
        return exceptionMessage;
    }
}
