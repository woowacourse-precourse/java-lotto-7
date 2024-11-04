package lotto;

public enum ErrorMessage {
    NOT_INTEGER("정수를 입력해주세요."),

    NOT_ENOUGH_PURCHASE_AMOUNT("구입 금액은 최소 1000원 이상입니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE("구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    PURCHASE_AMOUNT_EXCEED_LIMIT("구입 금액은 100000원 이하여야 합니다."),

    INVALID_WINNING_NUMBERS_COUNT("당첨 번호는 6개여야 합니다."),
    NOT_UNIQUE_WINNING_NUMBER("당첨 번호는 중복되지 않아야 합니다."),

    BONUS_NUMBER_IN_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),

    NOT_UNIQUE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호의 범위는 1~45여야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
