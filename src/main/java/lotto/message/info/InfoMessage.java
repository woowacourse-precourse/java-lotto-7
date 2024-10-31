package lotto.message.info;

public enum InfoMessage {
    REQUEST_PURCHASE_AMOUT("구입 금액을 입력해 주세요.");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
