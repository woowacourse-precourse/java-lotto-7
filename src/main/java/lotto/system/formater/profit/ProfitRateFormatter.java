package lotto.system.formater.profit;

public class ProfitRateFormatter { // 수익률 환산

    private final static String PROFIT_RATE_MESSAGE = "총 수익률은 %d입니다.";

    public static String formatAsMessage (int profitRate) {
        return String.format(PROFIT_RATE_MESSAGE, profitRate);
    }
}
