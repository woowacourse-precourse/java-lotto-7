package content;

public enum OutputMessage {
    BUY_COUNT_MESSAGE("개를 구매했습니다."),
    COUNT_MESSAGE("개"),
    RESULT_MESSAGE("총 수익률은 %.1f%%입니다.%n");

    public String getMessage() {
        return message;
    }

    OutputMessage(String message) {
        this.message = message;
    }

    private final String message;
}
