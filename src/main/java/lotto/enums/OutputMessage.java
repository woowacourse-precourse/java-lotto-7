package lotto.enums;

public enum OutputMessage {
    NUMBER_OF_PURCHASE_OUTPUT("%d개를 구매했습니다."),
    STRING_WINNING_STATISTIC_OUTPUT("당첨 통계\n---"),
    WINNING_STATISTICS_OUTPUT("%s (%,d원) - %d개"),
    RATE_OF_RETURN_OUTPUT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
