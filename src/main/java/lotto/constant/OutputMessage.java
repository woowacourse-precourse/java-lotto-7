package lotto.constant;

public enum OutputMessage {
    PURCHASE_PRICE_INPUT_MESSAGE("구입금액을 입력해 주세요.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
