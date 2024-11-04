package lotto;

public enum InputMessage {
    LOTTO_COUNT("%s개를 구매했습니다.");

    private final String inputMessage;


    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

}
