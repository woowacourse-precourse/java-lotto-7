package lotto.util;

public class OutputMessage {
    public static final String SUCCESS_TICKET_PURCHASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_STATISTIC = "당첨 통계";
    public static final String DASH_LINES = "---";

    public enum PrizeMessage {
        THREE_MATCHING("3개 일치 (5,000원) - "),
        FOUR_MATCHING("4개 일치 (50,000원) - "),
        FIVE_MATCHING("5개 일치 (1,500,000원) - "),
        FIVE_MATCHING_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX_MATCHING("6개 일치 (2,000,000,000원) - ");

        private final String message;

        PrizeMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static final String TOTAL_PROFIT = "총 수익률은 ";
}
