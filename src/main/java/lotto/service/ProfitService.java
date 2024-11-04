package lotto.service;

import lotto.model.WinningLotto;
import lotto.util.Constants;

public class ProfitService {
    public double calculate(int lottoCount) {
        int totalSpent = lottoCount * Constants.LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();

        double profitRate = (double) totalPrize / totalSpent;

        return Math.round(profitRate * 10.0) / 10.0;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;

        for (WinningLotto winning : WinningLotto.values()) {
            totalPrize += winning.getPrize() * winning.getMatchCount();
        }

        return totalPrize;
    }
}
