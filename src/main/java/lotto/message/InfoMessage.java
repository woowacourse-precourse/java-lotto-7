package lotto.message;

public enum InfoMessage {
    SPLIT_DELIMITER(","),
    NUMBER_DELIMITER(", "),
    LOTTO_COUNT_INFO("\n{}개를 구매했습니다."),
    WINNING_STATS_LABEL("\n당첨 통계\n---"),
    THREE_NUMBERS_MATCH("3개 일치 (5,000원) - {}개"),
    FOUR_NUMBERS_MATCH("4개 일치 (50,000원) - {}개"),
    FIVE_NUMBERS_MATCH("5개 일치 (1,500,000원) - {}개"),
    FIVE_NUMBERS_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - {}개"),
    SIX_NUMBERS_MATCH("6개 일치 (2,000,000,000원) - {}개"),
    PROFIT_RATE_INFO("총 수익률은 {}%입니다.");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatProfit(double profit){
        String roundedProfit = String.format("%,.1f", profit);
        return message.replace("{}", roundedProfit);
    }

    public String formatNumber(long num){
        return message.replace("{}", String.valueOf(num));
    }
}
