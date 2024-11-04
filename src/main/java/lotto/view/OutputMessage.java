package lotto.view;

public enum OutputMessage {
    LOTTO_PURCHASE("%d개를 구매했습니다.\n"),
    LOTTO_NUMBER("[%s]\n"),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    RANK_STATISTIC("%d개 일치 (%,d원) - %d개\n"),
    SECOND_STATISTIC("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    RETURN_RATE("총 수익률은 %,.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
