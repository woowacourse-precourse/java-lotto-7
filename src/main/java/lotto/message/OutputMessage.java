package lotto.message;

import java.util.List;

public enum OutputMessage {
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_DIVIDER("---"),
    MATCH_3("3개 일치 (5,000원) - %d개"),
    MATCH_4("4개 일치 (50,000원) - %d개"),
    MATCH_5("5개 일치 (1,500,000원) - %d개"),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_6("6개 일치 (2,000,000,000원) - %d개"),
    REVENUE_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static List<OutputMessage> getWinningRankMessages() {
        return List.of(MATCH_3, MATCH_4, MATCH_5, MATCH_5_BONUS, MATCH_6);
    }
}