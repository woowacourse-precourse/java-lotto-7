package lotto.constant;

public enum OutputMessage {
    LOTTO_COUNT_FORMAT("%d개를 구매했습니다.%n"),
    LOTTO_FORMAT("[%s]");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
