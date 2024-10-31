package io;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요.")
    ;

    private final String outputMessage;

    private OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
