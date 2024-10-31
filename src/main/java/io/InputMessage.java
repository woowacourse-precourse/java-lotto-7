package io;

public enum InputMessage {
    NEW_LINE("\r\n"),
    PURCHASE_LOTTO_COUNT("개를 구매했습니다.");

    private final String inputMessage;

    private InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
