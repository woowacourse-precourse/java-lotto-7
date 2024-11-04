package lotto.view;

public enum OutputViewMessage {
    LOTTO_BUY_COUNT_MESSAGE("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTICS_START_MESSAGE("\n당첨 통계\n---"),
    WINNING_STATISTICS("%d개 일치%s (%s원) - %d개\n"),
    BONUS_MATCH(", 보너스 볼 일치"),
    EMPTY_STRING("");
    private final String message;

    OutputViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
