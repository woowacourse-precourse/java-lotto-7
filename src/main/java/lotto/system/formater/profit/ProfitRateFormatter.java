package lotto.system.formater.profit;

public class ProfitRateFormatter { // 수익률 포맷

    private final double profitRate;

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public ProfitRateFormatter(double profitRate) {
        this.profitRate = profitRate;
    }

    public String formatAsMessage() {
        return String.format(PROFIT_RATE_MESSAGE, profitRate);
    }
}