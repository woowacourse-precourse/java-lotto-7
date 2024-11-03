package lotto;

public enum ErrorMessage {

    NOT_ENOUGH_PURCHASE_AMOUNT("[ERROR] 구입 금액은 최소 1000원 이상입니다.\n"),
    PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE("[ERROR] 구입 금액은 1000원으로 나누어떨어져야합니다.\n"),
    PURCHASE_AMOUNT_EXCEED_LIMIT("[ERROR] 구입 금액은 100000원 이하여야합니다.\n"),

    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개여야합니다.\n"),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호의 범위는 1~45여야 합니다.\n"),
    NOT_UNIQUE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복되지 않아야 합니다.\n");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
