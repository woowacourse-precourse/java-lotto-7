package lotto.constant;

public enum OutputMessage {

    LOTTO_PURCHASED_OUTPUT_MESSAGE("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
