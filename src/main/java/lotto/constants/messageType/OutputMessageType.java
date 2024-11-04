package lotto.constants.messageType;

public enum OutputMessageType {

    OUTPUT_BUY_LOTTO_MESSAGE_GUIDE("개를 구매했습니다.");

    private final String message;

    OutputMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
