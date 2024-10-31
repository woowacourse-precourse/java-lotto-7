package lotto.util.messages;

public enum OutputMessage {
    OUTPUT_NUMBER_OF_LOTTO("\n%d개를 구매했습니다.\n"),
    OUTPUT_RESULT("\n당첨 통계\n---"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
