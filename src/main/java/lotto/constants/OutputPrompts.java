package lotto.constants;

public enum OutputPrompts {
    PURCHASE_RESULT("구매 결과: %d개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계\n---"),
    MATCHED_THREE("3개 일치 (5,000원) - %d개"),
    MATCHED_FOUR("4개 일치 (50,000원) - %d개"),
    MATCHED_FIVE("5개 일치 (1,500,000원) - %d개"),
    MATCHED_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCHED_SIX("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputPrompts(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
