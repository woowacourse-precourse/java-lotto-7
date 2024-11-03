package lotto.view;

public enum OutputMessage {
    SHOW_PURCHASE_COUNT("%d개를 구매했습니다."),
    SHOW_STATISTICS_INTRO("당첨 통계"),
    SHOW_SEPARATOR_LINE("---"),
    SHOW_MATCH_RESULT("%d개 일치 (%s원) - %d개"),
    SHOW_MATCH_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    SHOW_TOTAL_PROFIT("총 수익률은 %.2f입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
