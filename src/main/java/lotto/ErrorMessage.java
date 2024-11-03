package lotto;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_ENOUGH("[ERROR] 구입 금액은 최소 1000원 이상입니다.\n"),
    PURCHASE_AMOUNT_NOT_MULTIPLE_LOTT_PRICE("[ERROR] 구입 금액은 1000원으로 나누어떨어져야합니다.\n"),
    PURCHASE_AMOUNT_EXCEED_LIMIT("[ERROR] 구입 금액은 100000원 이하여야합니다.\n");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
