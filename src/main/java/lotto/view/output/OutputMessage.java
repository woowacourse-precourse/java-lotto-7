package lotto.view.output;

public enum OutputMessage {
    PURCHASED_COUNT_MESSAGE("\n%d개를 구매했습니다.\n");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
