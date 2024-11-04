package lotto.view;

public enum OutputViewMessage {
    LOTTO_BUY_COUNT_MESSAGE("\n%d개를 구매했습니다.\n");
    private final String message;

    OutputViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
