package lotto.constants;

public enum OutputPrompts {
    PURCHASE_RESULT("\n%d개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계\n---"),
    MATCHED_THREE("3개 일치 (5,000원) - %d개\n"),
    MATCHED_FOUR("4개 일치 (50,000원) - %d개\n"),
    MATCHED_FIVE("5개 일치 (1,500,000원) - %d개\n"),
    MATCHED_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MATCHED_SIX("6개 일치 (2,000,000,000원) - %d개\n"),
    TOTAL_PROFIT_RATE("총 수익률은 %s%%입니다.\n");

    private final String message;

    OutputPrompts(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
