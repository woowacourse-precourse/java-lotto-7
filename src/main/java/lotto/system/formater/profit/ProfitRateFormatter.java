package lotto.system.formater.profit;

import static lotto.system.utils.constants.ProfitMessage.CONTENT;

public class ProfitRateFormatter { // 수익률 환산

    public static String formatAsMessage(double profitRate) {
        return String.format(CONTENT.getMessage(), profitRate);
    }
}
