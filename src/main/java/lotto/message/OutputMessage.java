package lotto.message;

public enum OutputMessage {
    NUMBER_OF_PURCHASE_OUTPUT("%d개를 구매했습니다."),
    STRING_WINNING_STATISTIC_OUTPUT("당첨 통계\n---"),
    WINNING_STATISTICS_OUTPUT("%d개 일치 (%d원) - %d개"),
    BONUS_WINNING_STATISTICS_OUTPUT("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    TOTAL_RETURN_OUTPUT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
