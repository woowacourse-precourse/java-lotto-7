package lotto.util;

public enum Constants {
    PURCHASE_PRICE_INPUT_PROMPT("구입금액을 입력해 주세요.");

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}