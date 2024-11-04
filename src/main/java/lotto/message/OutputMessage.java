package lotto.message;

public enum OutputMessage {
    REQUEST_INPUT_AMOUNT("구입금액을 입력해 주세요.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
