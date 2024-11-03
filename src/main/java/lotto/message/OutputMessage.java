package lotto.message;

public enum OutputMessage {
    PURCHASE_COUNT("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
