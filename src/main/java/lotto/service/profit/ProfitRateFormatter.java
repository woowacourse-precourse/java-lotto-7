package lotto.service.profit;

import static lotto.config.ProfitMessage.CONTENT;

public class ProfitRateFormatter { // 수익률 환산

    public static String formatAsMessage(double profitRate) {
        return String.format(CONTENT.getMessage(), profitRate);
    }
}
