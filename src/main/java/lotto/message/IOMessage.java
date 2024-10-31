package lotto.message;

public enum IOMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");
    private final String ioMessage;

    IOMessage(String ioMessage) {
        this.ioMessage = ioMessage;
    }

    public String getMessage() {
        return ioMessage;
    }
}
