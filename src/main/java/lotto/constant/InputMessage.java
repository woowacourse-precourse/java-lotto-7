package lotto.constant;

public enum InputMessage {

    PRICE_INPUT_MESSAGE("구입금액을 입력해주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
