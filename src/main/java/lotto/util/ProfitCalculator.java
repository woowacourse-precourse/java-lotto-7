package lotto.util;

import lotto.domain.Prize;
import lotto.domain.Purchase;

public class ProfitCalculator {
    private ProfitCalculator() {
    }

    public static double calculateProfit(Prize prize, Purchase purchase) {
        double profit = (double) prize.getMoney() / purchase.getMoney() * 100;
        return Math.round(profit * 100) / 100.0;
    }
}
